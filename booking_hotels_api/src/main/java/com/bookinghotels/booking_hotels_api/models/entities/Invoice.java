package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy = "mainIvoice")
    private List<InvoiceItem> invoiceItems;

    @OneToOne(mappedBy = "invoice")
    private Transaction transaction;

    @OneToOne
    private Booking booking;

}