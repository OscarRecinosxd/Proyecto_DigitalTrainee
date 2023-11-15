package com.bookinghotels.booking_hotels_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hotel_chains")
@Data
public class HotelChain {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy = "hotelChain")
    @JsonIgnore
    private List<HotelBranch> hotel_branches;

}
