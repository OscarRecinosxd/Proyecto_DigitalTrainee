package com.bookinghotels.booking_hotels_api.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "hotel_branches")
@Data
public class HotelBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  name;

    @JsonIgnore
    private Point location;

    private String address;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "check_in_time")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime checkInTime;

    @Column(name = "check_out_time")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime checkOutTime;

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
