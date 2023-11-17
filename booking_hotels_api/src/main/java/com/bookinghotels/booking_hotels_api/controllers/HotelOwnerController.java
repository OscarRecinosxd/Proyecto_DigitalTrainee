package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.CreateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.models.entities.Room;
import com.bookinghotels.booking_hotels_api.services.IService.RoomService;
import com.bookinghotels.booking_hotels_api.utils.ResponseDTO;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel-owner")

public class HotelOwnerController {
    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<?> getHotelBranches() {
        return ResponseEntity.ok(new ResponseDTO<>(roomService.findAll(), "Consulta a habitaciones exitosa"));
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> getHotelBranches(@PathVariable Long id) {
        Room roomFound = roomService.findById(id);
        if (roomFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe la habitacion"));
        }

        return ResponseEntity.ok().body(new ResponseDTO<>(roomFound, "Habitacion encontrada con exito"));
    }

    @PostMapping("/rooms")
    public ResponseEntity<?> saveHotelBranch(@RequestBody CreateRoomDTO newHotelRoom){
        Room roomCreated = roomService.save(newHotelRoom);

        return ResponseEntity.ok().body(new ResponseDTO<>(roomCreated, "Habitacion de hotel creada con exito"));
    }

    @PutMapping("/rooms/{id}")
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
    }

}
