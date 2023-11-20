package com.bookinghotels.booking_hotels_api.repositories;

import com.bookinghotels.booking_hotels_api.models.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
