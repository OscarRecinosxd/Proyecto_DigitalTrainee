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

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "hotel_branch_id")
    private HotelBranch hotelBranch;

    @OneToMany(mappedBy = "hotelBranchScheduleId")
    private List<ScheduleDay> scheduleDays;

}