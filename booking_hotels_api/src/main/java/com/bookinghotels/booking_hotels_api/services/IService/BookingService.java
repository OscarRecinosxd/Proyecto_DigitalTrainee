package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateBookingDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.BookingResponseDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelBranchResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.Booking;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.models.entities.Room;

import java.util.List;

public interface BookingService {

    List<Booking> findAll();

    List<Booking> findAllByUser(Long id);

    Booking findById(Long id);

    Booking save(CreateBookingDTO newBookingDTO);

    Booking deleteBooking(Long id);

    BookingResponseDTO converToDTO(Booking booking);

    List<BookingResponseDTO> converListToDTOList(List<Booking> bookings);


}
