package com.bookinghotels.booking_hotels_api.repositories;

import com.bookinghotels.booking_hotels_api.models.entities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {
}
