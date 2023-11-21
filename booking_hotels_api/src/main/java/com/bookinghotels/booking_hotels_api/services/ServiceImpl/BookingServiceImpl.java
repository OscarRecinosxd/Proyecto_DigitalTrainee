package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateBookingDTO;
import com.bookinghotels.booking_hotels_api.models.entities.Booking;
import com.bookinghotels.booking_hotels_api.models.entities.Room;
import com.bookinghotels.booking_hotels_api.models.entities.User;
import com.bookinghotels.booking_hotels_api.repositories.BookingRepository;
import com.bookinghotels.booking_hotels_api.repositories.UserRepository;
import com.bookinghotels.booking_hotels_api.services.IService.BookingService;
import com.bookinghotels.booking_hotels_api.services.IService.RoomService;
import com.bookinghotels.booking_hotels_api.services.IService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;



    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findAllByUser(Long id) {
        User user = userService.findById(id);
        if (user == null){
            return null;
        }

        return bookingRepository.findAllByUser(user);
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking save(CreateBookingDTO newBookingDTO) {
        Long userId = newBookingDTO.getUserId();
        Long[] roomsId = newBookingDTO.getRoomsId();
        User user = userService.findById(userId);
        if (user == null){
            return null;
        }
        List<Room> bookingRooms = new ArrayList<>();
        for (int i = 0; i < roomsId.length; i++){
            Room room = roomService.findById(roomsId[i]);
            if(room == null) {return null;}
            bookingRooms.add(room);
        }
        Booking newBooking = new Booking();
        LocalDateTime startDate = newBookingDTO.getStartDate();
        LocalDateTime endDate = newBookingDTO.getEndDate();


        newBooking.setStartDate(startDate);
        newBooking.setEndDate(endDate);
        newBooking.setUser(user);
        newBooking.setRooms(bookingRooms);
        newBooking.setPaid(false);

        newBooking = bookingRepository.save(newBooking);



        return newBooking;
    }

    @Override
    public Booking deleteBooking(Long id) {
        Booking deletedBooking = bookingRepository.findById(id).orElse(null);
        if(deletedBooking == null){
            return null;
        }
        deletedBooking.setDeleted(true);
        deletedBooking = bookingRepository.save(deletedBooking);

        return deletedBooking;
    }

}
