package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "schedule_days")
@Data
public class ScheduleDay {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_days_seq")
    @SequenceGenerator(name = "schedule_days_seq",sequenceName = "schedule_days_seq",allocationSize = 1)
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
    private HotelBranchSchedule hotelBranchScheduleId;
}
