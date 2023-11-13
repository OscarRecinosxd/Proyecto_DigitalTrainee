package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "total_amount")
    private float totalAmount;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;
}