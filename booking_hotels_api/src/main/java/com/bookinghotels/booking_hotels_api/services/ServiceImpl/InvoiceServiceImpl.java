package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.Invoice;
import com.bookinghotels.booking_hotels_api.repositories.InvoiceRepository;
import com.bookinghotels.booking_hotels_api.services.IService.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice create(Invoice invoice) {
        invoice = invoiceRepository.save(invoice);
        return invoice;
    }
}
