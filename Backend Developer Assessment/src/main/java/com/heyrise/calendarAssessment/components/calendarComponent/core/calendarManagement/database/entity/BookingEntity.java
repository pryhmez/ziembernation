package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity(name = "booking")
public class BookingEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(unique = true)
    private String id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "calendar_id")
    private CalendarEntity calendar;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @PrePersist
    public void prePersist() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }


}
