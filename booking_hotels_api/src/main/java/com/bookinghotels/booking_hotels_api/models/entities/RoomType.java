package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "room_types")
@Data
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms;
}