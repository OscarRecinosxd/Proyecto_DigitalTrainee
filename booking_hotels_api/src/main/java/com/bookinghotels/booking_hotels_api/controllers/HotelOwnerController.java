package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.RoomResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.models.entities.Room;
import com.bookinghotels.booking_hotels_api.services.IService.RoomService;
import com.bookinghotels.booking_hotels_api.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel-owner")

public class HotelOwnerController {
    @Autowired
    RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<?> getRooms() {
        List<Room> hotelBranches = roomService.findAll();
        if (hotelBranches == null){
            return ResponseEntity.ok(new ResponseDTO<>(null, "No hay ningun usuario"));
        }
        List<RoomResponseDTO> roomResponseDTOS = roomService.converListToDTO(hotelBranches);
        return ResponseEntity.ok(new ResponseDTO<>(roomResponseDTOS, "Consulta a habitaciones exitosa"));
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> getRoom(@PathVariable Long id) {
        Room roomFound = roomService.findById(id);
        if (roomFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe la habitacion"));
        }
        RoomResponseDTO roomResponseDTO = roomService.converToDTO(roomFound);

        return ResponseEntity.ok().body(new ResponseDTO<>(roomResponseDTO, "Habitacion encontrada con exito"));
    }

    @PostMapping("/rooms")
    public ResponseEntity<?> saveRoom(@RequestBody CreateRoomDTO newHotelRoom){
        Room roomCreated = roomService.save(newHotelRoom);
        if (roomCreated == null) {
            return ResponseEntity.internalServerError().body(new ResponseDTO<>(null, "Hubo un error"));
        }
        RoomResponseDTO roomResponseDTO = roomService.converToDTO(roomCreated);
        return ResponseEntity.ok().body(new ResponseDTO<>(roomResponseDTO, "Habitacion de hotel creada con exito"));
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id, @RequestBody UpdateRoomDTO updateRoomDTO) {
        Room hotelRoomUpdated = roomService.updateRoom(id, updateRoomDTO);
        if (hotelRoomUpdated == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Habitacion no existe"));
        }
        RoomResponseDTO roomResponseDTO = roomService.converToDTO(hotelRoomUpdated);
        return ResponseEntity.ok().body(new ResponseDTO<>(roomResponseDTO, "Habitacion editada con exito"));

    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        Room roomDeleted = roomService.deleteById(id);
        if (roomDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Habitacion no encontrado"));
        }
        RoomResponseDTO roomResponseDTO = roomService.converToDTO(roomDeleted);
        return ResponseEntity.ok().body(new ResponseDTO<>(roomDeleted, "Habitacion borrada con exito"));
    }

}
