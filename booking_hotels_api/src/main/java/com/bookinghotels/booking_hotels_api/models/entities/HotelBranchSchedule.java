package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hotel_branch_schedules")
@Data
public class HotelBranchSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    @OneToOne(mappedBy = "hotelBranchSchedule")
    private HotelBranch hotelBranch;

    @OneToMany(mappedBy = "hotelBranchScheduleId")
    private List<ScheduleDay> scheduleDays;

}