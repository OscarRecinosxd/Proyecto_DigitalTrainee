package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateBookingDTO;
import com.bookinghotels.booking_hotels_api.models.entities.Booking;
import com.bookinghotels.booking_hotels_api.models.entities.Room;

import java.util.List;

public interface BookingService {

    List<Booking> findAll();

    List<Booking> findAllByUser(Long id);

    Booking findById(Long id);

    Booking save(CreateBookingDTO newBookingDTO, Long userId, Long[] roomsId);

}
