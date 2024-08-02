package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.dataMapper;


import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto.CalendarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.CalendarEntity;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource.CalendarResource;

@Mapper
public interface CalendarDataMapper {
    CalendarDataMapper INSTANCE = Mappers.getMapper(CalendarDataMapper.class);

    CalendarResource convertCalendarEntityToResource(CalendarEntity entity);

    @Mapping(target = "id", ignore = true)
    CalendarEntity convertCalendarDtoToEntity(CalendarDto dto);

    CalendarDto convertCalendarEntityToDto(CalendarEntity entity);
}