package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.repository;

import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, String> {

    List<BookingEntity> findByCalendarIdAndDate(String calendarId, LocalDate date);

    boolean existsByCalendarIdAndDateAndStartTimeLessThanAndEndTimeGreaterThan(
            String calendarId, LocalDate date, LocalTime endTime, LocalTime startTime
    );

    List<BookingEntity> findByCalendarIdAndDateBetween(String calendarId, LocalDate startDate, LocalDate endDate);

    boolean existsByDateAndStartTimeLessThanAndEndTimeGreaterThan(LocalDate date, LocalTime endTime, LocalTime startTime);

    List<BookingEntity> findByDate(LocalDate date);

    List<BookingEntity> findByDateBetweenAndStartTimeLessThanAndEndTimeGreaterThan(
            LocalDate startDate, LocalDate endDate, LocalTime endTime, LocalTime startTime);

}
