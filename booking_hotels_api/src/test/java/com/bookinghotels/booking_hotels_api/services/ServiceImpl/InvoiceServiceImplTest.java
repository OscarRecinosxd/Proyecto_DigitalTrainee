package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.Invoice;
import com.bookinghotels.booking_hotels_api.repositories.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceServiceImplTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    void create() {
        InvoiceServiceImpl invoiceService = new InvoiceServiceImpl(invoiceRepository);
        Invoice newInvoice = new Invoice();

        Invoice createdInvoice = invoiceService.create(newInvoice);
        assertNotNull(createdInvoice);
    }
}