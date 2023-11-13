package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "schedule_days")
@Data
public class ScheduleDay {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "week_day")
    private String  weekDay;

    @Column(name = "opens_time")
    private LocalTime opensTime;

    @Column(name = "closes_Time")
    private LocalTime closesTime;
}