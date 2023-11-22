package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateBookingDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.CreateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.BookingResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.Booking;
import com.bookinghotels.booking_hotels_api.models.entities.Room;
import com.bookinghotels.booking_hotels_api.services.IService.BookingService;
import com.bookinghotels.booking_hotels_api.services.IService.RoomService;
import com.bookinghotels.booking_hotels_api.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<?> getBookings(@RequestParam Long idUser) {
        List<Booking> userBookings = bookingService.findAllByUser(idUser);
        if (userBookings == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No posees habitaciones reservadas"));
        }
        List<BookingResponseDTO> bookingResponseDTOS = bookingService.converListToDTOList(userBookings);

        return ResponseEntity.ok(new ResponseDTO<>(bookingResponseDTOS, "Consulta a reservaciones exitosa"));
    }

    @GetMapping("/bookings/get/{id}")
    public ResponseEntity<?> getBooking(@PathVariable Long id) {
        Booking bookingFound = bookingService.findById(id);
        if (bookingFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe la reservacion"));
        }
        BookingResponseDTO bookingResponseDTOS = bookingService.converToDTO(bookingFound);

        return ResponseEntity.ok().body(new ResponseDTO<>(bookingResponseDTOS, "Reservacion encontrada con exito"));
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> saveBooking(@RequestBody CreateBookingDTO newBookingDTO){
        Booking bookingCreated = bookingService.save(newBookingDTO);

        if (bookingCreated == null){
            return ResponseEntity.internalServerError().body(new ResponseDTO<>(null, "Hubo un error"));

        }

        BookingResponseDTO bookingResponseDTOS = bookingService.converToDTO(bookingCreated);

        return ResponseEntity.ok().body(new ResponseDTO<>(bookingResponseDTOS, "Reservacion creada con exito"));
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        Booking bookingDelete = bookingService.deleteBooking(id);
        if (bookingDelete == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Habitacion no encontrado"));
        }

        BookingResponseDTO bookingResponseDTOS = bookingService.converToDTO(bookingDelete);

        return ResponseEntity.ok().body(new ResponseDTO<>(bookingResponseDTOS, "Habitacion borrada con exito"));

    }


}
