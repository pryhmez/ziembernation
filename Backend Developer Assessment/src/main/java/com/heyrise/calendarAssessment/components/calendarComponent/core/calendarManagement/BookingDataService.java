package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement;

import com.heyrise.calendarAssessment.common.restException.HeyRiseResourceNotFoundException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception.BookingNotFoundException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception.BookingOverlapException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception.CalendarNotFoundException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto.BookingDto;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource.BookingResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookingDataService {

    @Autowired
    private BookingManager bookingManager;

    public BookingResource getBooking(String id) {
        try {
            return bookingManager.getBooking(id).getResource();
        } catch (BookingNotFoundException e) {
            throw new HeyRiseResourceNotFoundException("Booking not found");
        }
    }

    public BookingResource createOrUpdateBooking(BookingDto bookingDto) {
        try {
            return bookingManager.createOrUpdateBooking(bookingDto).getResource();
        } catch (BookingOverlapException | CalendarNotFoundException e) {
            throw new HeyRiseResourceNotFoundException("Booking overlaps with an existing booking");
        }
    }

    public void deleteBooking(String id) {
        try {
            bookingManager.deleteBooking(id);
        } catch (BookingNotFoundException e) {
            throw new HeyRiseResourceNotFoundException("Booking not found");
        }
    }

    public List<LocalTime> calculatePossibleBookingTimes(LocalDate date, int durationInMinutes) {
        return bookingManager.calculatePossibleBookingTimes(date, durationInMinutes);
    }

    public List<LocalDate> getAvailableDates(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> availableDates = new ArrayList<>();

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (isDateAvailable(currentDate)) {
                availableDates.add(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }

        return availableDates;
    }

    private boolean isDateAvailable(LocalDate date) {
        // Check if there are any bookings for the given date
        List<BookingEntity> bookings = bookingManager.getBookingsForDate(date);
        return bookings.isEmpty(); // Date is available if no bookings exist
    }
}
