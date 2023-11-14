package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    @Column(name = "check_out_time")
    private LocalTime checkOutTime;

    private int capacity;

    private float price;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "hotel_branch_id")
    private HotelBranch hotelBranch;

    @ManyToMany(mappedBy = "rooms")
    private List<Booking> bookings;
}