package com.bookinghotels.booking_hotels_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Point;

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

    @JsonIgnore
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
    @JsonIgnore
    private HotelBranchType hotelBranchType;

    @OneToOne(mappedBy = "hotelBranch")
    @JsonIgnore
    private HotelBranchSchedule hotelBranchSchedule;

    @OneToMany(mappedBy = "hotelBranch")
    @JsonIgnore
    private List<Room> rooms;

}
