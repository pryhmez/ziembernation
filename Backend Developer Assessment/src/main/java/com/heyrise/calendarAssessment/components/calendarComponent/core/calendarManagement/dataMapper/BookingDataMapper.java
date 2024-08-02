package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.dataMapper;


import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.dto.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource.BookingResource;

@Mapper
public interface BookingDataMapper {
    BookingDataMapper INSTANCE = Mappers.getMapper(BookingDataMapper.class);

    BookingResource convertBookingEntityToResource(BookingEntity entity);

//    @Mapping(target = "id", ignore = true)
    BookingEntity convertBookingDtoToEntity(BookingDto dto);

    BookingDto convertBookingEntityToDto(BookingEntity entity);
}