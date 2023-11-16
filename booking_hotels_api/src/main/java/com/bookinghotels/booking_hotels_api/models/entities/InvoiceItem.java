package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "invoice_items")
@Data
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_items_seq")
    @SequenceGenerator(name = "invoice_items_seq",sequenceName = "invoice_items_seq",allocationSize = 1)
    private Long id;

    private String description;

    private float amount;

    private int quantity;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice mainIvoice;
}