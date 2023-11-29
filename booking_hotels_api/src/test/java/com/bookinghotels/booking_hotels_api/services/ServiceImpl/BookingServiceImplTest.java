package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateBookingDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.CreateUserDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.BookingResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.Booking;
import com.bookinghotels.booking_hotels_api.models.entities.User;
import com.bookinghotels.booking_hotels_api.repositories.BookingRepository;
import com.bookinghotels.booking_hotels_api.services.IService.BookingService;
import com.bookinghotels.booking_hotels_api.services.IService.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingServiceImplTest {

    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;

    @Test
    void converToDTO() {
        Booking booking = new Booking();
        BookingResponseDTO bookingResponseDTO = bookingService.converToDTO(booking);
        assertNotNull(bookingResponseDTO);

    }

    @Test
    void converListToDTOList() {
        List<Booking> bookings = new ArrayList<>();
        List<BookingResponseDTO> bookingResponseDTOS = new ArrayList<>();
        bookingResponseDTOS = bookingService.converListToDTOList(bookings);
        assertNotNull(bookingResponseDTOS);
    }
}