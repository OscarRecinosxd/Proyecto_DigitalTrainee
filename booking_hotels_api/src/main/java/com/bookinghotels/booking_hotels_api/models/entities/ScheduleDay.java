package com.bookinghotels.booking_hotels_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "schedule_days")
@Data
public class ScheduleDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "week_day")
    private String  weekDay;

    @Column(name = "opens_time")
    private LocalTime opensTime;

    @Column(name = "closes_Time")
    private LocalTime closesTime;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    @JsonIgnore
    private HotelBranchSchedule hotelBranchScheduleId;
}
