package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class CalendarDto {

    @NotNull
    private String name;
}
