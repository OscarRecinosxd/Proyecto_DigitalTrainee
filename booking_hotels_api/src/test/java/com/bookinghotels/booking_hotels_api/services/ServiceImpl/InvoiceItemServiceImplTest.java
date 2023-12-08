package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.InvoiceItem;
import com.bookinghotels.booking_hotels_api.repositories.InvoiceItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceItemServiceImplTest {

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Test
    void create() {
        InvoiceItemServiceImpl invoiceItemService = new InvoiceItemServiceImpl(invoiceItemRepository);
        InvoiceItem newInvoiceItem = new InvoiceItem();

        InvoiceItem createdItem = invoiceItemService.create(newInvoiceItem);
        assertNotNull(createdItem);
    }
}