package com.bookinghotels.booking_hotels_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import net.postgis.jdbc.geometry.Geometry;
import net.postgis.jdbc.geometry.Point;

import java.util.List;

@Entity
@Table(name = "hotel_branches")
@Data
public class HotelBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hotel_branches_seq")
    @SequenceGenerator(name = "hotel_branches_seq",sequenceName = "hotel_branches_seq",allocationSize = 1)
    private Long id;

    private String  name;

    private Point location;

    private String address;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "hotel_chain_id")
    @JsonIgnore
    private HotelChain hotelChain;

    @ManyToOne
    @JoinColumn(name = "hotel_branch_type_id")
    private HotelBranchType hotelBranchType;

    @OneToOne(mappedBy = "hotelBranch")
    private HotelBranchSchedule hotelBranchSchedule;

    @OneToMany(mappedBy = "hotelBranch")
    private List<Room> rooms;

}
