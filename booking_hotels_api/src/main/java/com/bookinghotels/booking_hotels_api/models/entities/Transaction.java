package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private float amount;

    private LocalDateTime payment_date_time;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}