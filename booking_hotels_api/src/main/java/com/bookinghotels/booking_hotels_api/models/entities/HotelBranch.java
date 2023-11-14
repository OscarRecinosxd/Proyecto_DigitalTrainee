package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import net.postgis.jdbc.geometry.Geometry;
import net.postgis.jdbc.geometry.Point;

@Entity
@Table(name = "hotel_branches")
@Data
public class HotelBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String  name;

    private Point location;

    private String address;

    @ManyToOne
    @JoinColumn(name = "hotel_chain_id")
    private HotelChain hotelChain;

    @ManyToOne
    @JoinColumn(name = "hotel_branch_type_id")
    private HotelBranchType hotelBranchType;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    private HotelBranchSchedule hotelBranchSchedule;

}
