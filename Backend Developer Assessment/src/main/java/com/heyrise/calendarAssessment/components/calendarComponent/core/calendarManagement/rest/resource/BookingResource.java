package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingResource {
    private String id;
    private String calendarId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
