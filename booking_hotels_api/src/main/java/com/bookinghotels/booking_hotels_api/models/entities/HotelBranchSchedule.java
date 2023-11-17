package com.bookinghotels.booking_hotels_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hotel_branch_schedules")
@Data
public class HotelBranchSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hotel_branch_schedules_seq")
    @SequenceGenerator(name = "hotel_branch_schedules_seq",sequenceName = "hotel_branch_schedules_seq",allocationSize = 1)
    private Long id;

    private String description;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "hotel_branch_id")
    @JsonIgnore
    private HotelBranch hotelBranch;

    @OneToMany(mappedBy = "hotelBranchScheduleId")
    @JsonIgnore
    private List<ScheduleDay> scheduleDays;

}