package com.bookinghotels.booking_hotels_api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    @SequenceGenerator(name = "room_seq",sequenceName = "room_seq",allocationSize = 1)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    @Column(name = "check_out_time")
    private LocalTime checkOutTime;

    private int capacity;

    private float price;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    @JsonIgnore
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "hotel_branch_id")
    @JsonIgnore
    private HotelBranch hotelBranch;

    @ManyToMany(mappedBy = "rooms")
    @JsonIgnore
    private List<Booking> bookings;
}