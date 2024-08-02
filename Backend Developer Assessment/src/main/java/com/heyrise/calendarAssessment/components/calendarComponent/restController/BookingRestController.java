package com.heyrise.calendarAssessment.components.calendarComponent.restController;


import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.BookingDataService;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto.BookingDto;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource.BookingResource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingRestController {

    @Autowired
    private BookingDataService bookingDataService;

    @GetMapping("/{id}")
    public BookingResource getBooking(@PathVariable String id) {
        return bookingDataService.getBooking(id);
    }

    @PostMapping
    public BookingResource createOrUpdateBooking(@Valid @RequestBody BookingDto bookingDto) {
        return bookingDataService.createOrUpdateBooking(bookingDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable String id) {
        bookingDataService.deleteBooking(id);
    }

    @GetMapping("/available-times")
    public List<LocalTime> calculatePossibleBookingTimes(@RequestParam LocalDate date, @RequestParam int durationInMinutes) {
        return bookingDataService.calculatePossibleBookingTimes(date, durationInMinutes);
    }

    @GetMapping("/available-dates")
    public List<LocalDate> getAvailableDates(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return bookingDataService.getAvailableDates(startDate, endDate);
    }
}
