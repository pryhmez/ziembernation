package com.heyrise.calendarAssessment.components.calendarComponent.restController;


import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.CalendarDataService;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto.CalendarDto;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource.CalendarResource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/calendars")
public class CalendarRestController {

    @Autowired
    private CalendarDataService calendarDataService;

    @GetMapping("/{id}")
    public CalendarResource getCalendar(@PathVariable String id) {
        return calendarDataService.getCalendar(id);
    }

    @PostMapping
    public CalendarResource createOrUpdateCalendar(@Valid @RequestBody CalendarDto calendarDto) {
        return calendarDataService.createOrUpdateCalendar(calendarDto);
    }

    @GetMapping("/all")
    public List<CalendarResource> getAllCalendars() {
        return calendarDataService.getAllCalendars();
    }
}