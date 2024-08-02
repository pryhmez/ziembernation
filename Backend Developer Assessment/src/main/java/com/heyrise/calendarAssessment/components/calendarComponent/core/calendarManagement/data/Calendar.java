package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.CalendarEntity;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource.CalendarResource;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.dataMapper.CalendarDataMapper;

@Data
@AllArgsConstructor
public class Calendar {
    private CalendarEntity calendarEntity;

    public CalendarResource getResource() {
        return CalendarDataMapper.INSTANCE.convertCalendarEntityToResource(calendarEntity);
    }
}