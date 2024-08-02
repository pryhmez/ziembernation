package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.repository;

import com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity.CalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarEntity, String> {
}