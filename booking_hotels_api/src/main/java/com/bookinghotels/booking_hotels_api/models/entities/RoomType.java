package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "room_types")
@Data
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_types_seq")
    @SequenceGenerator(name = "room_types_seq",sequenceName = "room_types_seq",allocationSize = 1)
    private Long id;

    private String description;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms;
}