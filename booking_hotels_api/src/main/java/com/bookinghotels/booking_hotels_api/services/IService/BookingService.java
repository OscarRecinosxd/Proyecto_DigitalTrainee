package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.entities.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> findAll();

}
