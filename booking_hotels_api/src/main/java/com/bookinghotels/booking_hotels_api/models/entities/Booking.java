package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.java.Log;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "is_paid")
    private boolean isPaid;
}