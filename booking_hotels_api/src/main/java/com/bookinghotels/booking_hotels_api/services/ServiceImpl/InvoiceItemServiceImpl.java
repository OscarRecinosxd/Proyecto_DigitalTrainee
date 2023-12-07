package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.InvoiceItem;
import com.bookinghotels.booking_hotels_api.repositories.InvoiceItemRepository;
import com.bookinghotels.booking_hotels_api.services.IService.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    private final InvoiceItemRepository invoiceItemRepository;

    @Autowired
    public InvoiceItemServiceImpl(InvoiceItemRepository invoiceItemRepository) {
        this.invoiceItemRepository = invoiceItemRepository;
    }
    @Override
    public InvoiceItem create(InvoiceItem invoiceItem) {
        invoiceItem = invoiceItemRepository.save(invoiceItem);

        return invoiceItem;
    }
}
