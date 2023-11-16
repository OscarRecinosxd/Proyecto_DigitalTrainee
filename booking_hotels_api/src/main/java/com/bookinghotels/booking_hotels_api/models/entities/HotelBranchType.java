package com.bookinghotels.booking_hotels_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hotel_branch_types")
@Data
public class HotelBranchType{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_branch_types_seq")
    @SequenceGenerator(name = "hotel_branch_types_seq",sequenceName = "hotel_branch_types_seq",allocationSize = 1)
    private Long id;

    private String name;

    private String description;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy = "hotelBranchType")
    @JsonIgnore
    private List<HotelBranch> hotel_branches;
}
