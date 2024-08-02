package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement;


import com.heyrise.calendarAssessment.common.restException.HeyRiseResourceNotFoundException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.data.Calendar;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception.CalendarNotFoundException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto.CalendarDto;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource.CalendarResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarDataService {

    @Autowired
    private CalendarManager calendarManager;

    public CalendarResource getCalendar(String id) {
        try {
            return calendarManager.getCalendar(id).getResource();
        } catch (CalendarNotFoundException e) {
            throw new HeyRiseResourceNotFoundException("Calendar not found");
        }
    }

    public CalendarResource createOrUpdateCalendar(CalendarDto calendarDto) {
        return calendarManager.createOrUpdateCalendar(calendarDto).getResource();
    }

    public List<CalendarResource> getAllCalendars() {
        return calendarManager.getAllCalendars().stream()
                .map(Calendar::getResource)
//                .map(calendar -> calendar.getResource())
                .collect(Collectors.toList());
    }

}
