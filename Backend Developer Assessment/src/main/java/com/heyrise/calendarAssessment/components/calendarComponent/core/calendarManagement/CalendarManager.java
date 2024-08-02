package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement;

import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.data.Calendar;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.dataMapper.CalendarDataMapper;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.CalendarEntity;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.repository.CalendarRepository;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception.CalendarNotFoundException;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto.CalendarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CalendarManager {

    @Autowired
    private CalendarRepository calendarRepository;

    public Calendar getCalendar(String id) throws CalendarNotFoundException {
        Optional<CalendarEntity> oCalendar = calendarRepository.findById(id);
        if (oCalendar.isEmpty()) {
            throw new CalendarNotFoundException("Calendar with id " + id + " was not found");
        }
        CalendarEntity calendarEntity = oCalendar.get();
        return new Calendar(calendarEntity);
    }

    public Calendar createOrUpdateCalendar(CalendarDto calendarDto) {
        CalendarEntity entity = CalendarDataMapper.INSTANCE.convertCalendarDtoToEntity(calendarDto);
        calendarRepository.save(entity);
        return new Calendar(entity);
    }

    public List<Calendar> getAllCalendars() {
        List<CalendarEntity> entityList = calendarRepository.findAll();
        return entityList.stream()
//                .map(entity -> new Calendar(entity))
                .map(Calendar::new)
                .collect(Collectors.toList());
    }
}
