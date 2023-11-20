package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateBookingDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.BookingResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.*;
import com.bookinghotels.booking_hotels_api.repositories.BookingRepository;
import com.bookinghotels.booking_hotels_api.repositories.UserRepository;
import com.bookinghotels.booking_hotels_api.services.IService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceItemService invoiceItemService;

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

        Invoice invoice = new Invoice();
        invoice.setIssueDate(LocalDateTime.now());
        float totalPrice = 0.00f;
        invoice.setDeleted(false);

        Long userId = newBookingDTO.getUserId();
        Long[] roomsId = newBookingDTO.getRoomsId();
        User user = userService.findById(userId);

        if (user == null){
            return null;
        }

        List<Room> bookingRooms = new ArrayList<>();
        for (Long aLong : roomsId) {
            Room room = roomService.findById(aLong);
            if (room == null) {
                return null;
            }
            totalPrice += room.getPrice();
            bookingRooms.add(room);
        }

        invoice.setTotalAmount(0);


        Booking newBooking = new Booking();

        Room roomAux = bookingRooms.get(0);
        LocalTime checkIn  = roomAux.getHotelBranch().getCheckInTime();
        LocalTime checkOut = roomAux.getHotelBranch().getCheckOutTime();


        LocalDateTime startDate = newBookingDTO.getStartDate().atTime(checkIn.getHour(),checkIn.getMinute());
        LocalDateTime endDate = newBookingDTO.getEndDate().atTime(checkOut.getHour(),checkOut.getMinute());


        newBooking.setStartDate(startDate);
        newBooking.setEndDate(endDate);
        newBooking.setUser(user);
        newBooking.setRooms(bookingRooms);
        newBooking.setPaid(false);

        newBooking = bookingRepository.save(newBooking);

        invoice.setBooking(newBooking);
        invoiceService.create(invoice);

        for (Room room : newBooking.getRooms()) {
            if (room == null) {
                return null;
            }
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setDescription("Renta de cuarto  :" + room.getNumber());
            invoiceItem.setAmount(room.getPrice());
            invoiceItem.setQuantity(newBooking.getDays());
            invoiceItem.setDeleted(false);
            invoiceItem.setMainIvoice(invoice);
            totalPrice = newBooking.getDays() * room.getPrice();
            invoiceItemService.create(invoiceItem);
        }

        invoice.setTotalAmount(totalPrice);
        invoiceService.create(invoice);

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

    @Override
    public BookingResponseDTO converToDTO(Booking booking) {
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        bookingResponseDTO.setId(booking.getId());
        bookingResponseDTO.setStartDate(booking.getStartDate());
        bookingResponseDTO.setEndDate(booking.getEndDate());
        bookingResponseDTO.setPaid(booking.isPaid());
        bookingResponseDTO.setDeleted(booking.isDeleted());
        bookingResponseDTO.setUser(booking.getUser());
        bookingResponseDTO.setInvoice(booking.getInvoice());
        bookingResponseDTO.setRooms(booking.getRooms());

        return bookingResponseDTO;
    }

    @Override
    public List<BookingResponseDTO> converListToDTOList(List<Booking> bookings) {
        List<BookingResponseDTO> bookingResponseDTOS = new ArrayList<>();

        bookings.forEach(booking -> bookingResponseDTOS.add(converToDTO(booking)));

        return bookingResponseDTOS;
    }

}
