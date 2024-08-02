package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement;

import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.data.Booking;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.data.Calendar;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.dataMapper.BookingDataMapper;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.dataMapper.CalendarDataMapper;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.CalendarEntity;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.repository.BookingRepository;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception.BookingNotFoundException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception.BookingOverlapException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception.CalendarNotFoundException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class BookingManager {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CalendarManager calendarManager;

    public Booking getBooking(String id) throws BookingNotFoundException {
        Optional<BookingEntity> oBooking = bookingRepository.findById(id);
        if (oBooking.isEmpty()) {
            throw new BookingNotFoundException("Booking with id " + id + " was not found");
        }
        BookingEntity bookingEntity = oBooking.get();
        return new Booking(bookingEntity);
    }

    public Booking createOrUpdateBooking(BookingDto bookingDto) throws BookingOverlapException, CalendarNotFoundException {
        if (bookingRepository.existsByDateAndStartTimeLessThanAndEndTimeGreaterThan(
                bookingDto.getDate(), bookingDto.getEndTime(), bookingDto.getStartTime())) {
            throw new BookingOverlapException("Booking overlaps with an existing booking");
        }

        Calendar calendar = calendarManager.getCalendar(bookingDto.getCalendarId());

        BookingEntity entity = BookingDataMapper.INSTANCE.convertBookingDtoToEntity(bookingDto);

        entity.setCalendar(calendar.getCalendarEntity());
        bookingRepository.save(entity);
        return new Booking(entity);
    }

    public void deleteBooking(String id) throws BookingNotFoundException {
        if (!bookingRepository.existsById(id)) {
            throw new BookingNotFoundException("Booking with id " + id + " was not found");
        }
        bookingRepository.deleteById(id);
    }

    public List<LocalTime> calculatePossibleBookingTimes(LocalDate date, int durationInMinutes) {
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(18, 0);

        List<BookingEntity> bookings = bookingRepository.findByDate(date);

        List<LocalTime> possibleTimes = IntStream.range(0, (int) startTime.until(endTime, java.time.temporal.ChronoUnit.MINUTES) + 1)
                .mapToObj(startTime::plusMinutes)
                .filter(time -> isAvailable(time, durationInMinutes, getBookingsForDate(date)))
                .collect(Collectors.toList());

        return possibleTimes;
    }

    private boolean isAvailable(LocalTime startTime, int durationInMinutes, List<BookingEntity> bookings) {
        LocalTime endTime = startTime.plusMinutes(durationInMinutes);
        for (BookingEntity booking : bookings) {
            if (booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(startTime)) {
                return false;
            }
        }
        return true;
    }

    public List<BookingEntity> getBookingsForDate(LocalDate date) {
        return bookingRepository.findByDate(date);
    }
}
