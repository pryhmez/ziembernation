package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.rest.resource.BookingResource;
import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.dataMapper.BookingDataMapper;

@Data
@AllArgsConstructor
public class Booking {
    private BookingEntity bookingEntity;

    public BookingResource getResource() {
        return BookingDataMapper.INSTANCE.convertBookingEntityToResource(bookingEntity);
    }
}
