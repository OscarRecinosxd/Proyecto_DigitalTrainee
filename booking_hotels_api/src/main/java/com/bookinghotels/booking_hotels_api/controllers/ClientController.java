package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateBookingDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.CreateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateRoomDTO;
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

        return ResponseEntity.ok(new ResponseDTO<>(userBookings, "Consulta a reservaciones exitosa"));
    }

    @GetMapping("/bookings/get/{id}")
    public ResponseEntity<?> getHotelBranches(@PathVariable Long id) {
        Booking bookingFound = bookingService.findById(id);
        if (bookingFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe la reservacion"));
        }

        return ResponseEntity.ok().body(new ResponseDTO<>(bookingFound, "Reservacion encontrada con exito"));
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> saveHotelBranch(@RequestBody CreateBookingDTO newBookingDTO,@RequestParam  Long userId, @RequestParam  Long[] roomsId){
        Booking bookingCreated = bookingService.save(newBookingDTO,userId,roomsId);

        return ResponseEntity.ok().body(new ResponseDTO<>(bookingCreated, "Reservacion creada con exito"));
    }

    /*@PutMapping("/rooms/{id}")
    public ResponseEntity<?> updateHotelBranch(@PathVariable Long id, @RequestBody UpdateRoomDTO updateRoomDTO) {
        Room hotelRoomUpdated = roomService.updateRoom(id, updateRoomDTO);
        if (hotelRoomUpdated == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Habitacion no existe"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelRoomUpdated, "Habitacion editada con exito"));

    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<?> deleteHotelBranch(@PathVariable Long id) {
        Room roomDeleted = roomService.deleteById(id);
        if (roomDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Habitacion no encontrado"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(roomDeleted, "Habitacion borrada con exito"));
    }*/


}
