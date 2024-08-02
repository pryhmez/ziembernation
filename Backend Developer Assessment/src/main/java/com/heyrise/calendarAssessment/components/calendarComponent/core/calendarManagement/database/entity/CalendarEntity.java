package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.database.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.UUID;

@Data
@Entity(name = "calendar")
public class CalendarEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(unique = true)
    protected String id;

    @Column(nullable = false)
    private String name;

    @PrePersist
    public void prePersist() {
        if (this.id == null || this.id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
