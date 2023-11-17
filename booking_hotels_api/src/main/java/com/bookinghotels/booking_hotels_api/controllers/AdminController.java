package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.*;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelChainsResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.models.entities.User;
import com.bookinghotels.booking_hotels_api.services.IService.HotelBranchService;
import com.bookinghotels.booking_hotels_api.services.IService.HotelChainService;
import com.bookinghotels.booking_hotels_api.services.IService.UserService;
import com.bookinghotels.booking_hotels_api.utils.ResponseDTO;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    HotelChainService hotelChainService;

    @Autowired
    HotelBranchService hotelBranchService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(new ResponseDTO<>(userService.findAll(), "Consulta a usuarios exitosa"));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        User userFound = userService.findById(id);
        if (userFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe el usuario"));
        }

        return ResponseEntity.ok().body(new ResponseDTO<>(userFound, "Usuario encontrado con exito"));
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody CreateUserDTO newUser) {
        User userCreated = userService.save(newUser);

        return ResponseEntity.ok().body(new ResponseDTO<>(userCreated, "Usuario creado con exito"));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO) {
        User userUpdated = userService.updateUser(id, updateUserDTO);
        if (userUpdated == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Usuario no existe"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(userUpdated, "Usuario editado con exito"));

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User userDeleted = userService.deleteById(id);
        if (userDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Usuario no encontrado"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(userDeleted, "Usuario borrado con exito"));
    }

    // ----------------------------------HOTEL CHAIN-----------------------------------------------

    @GetMapping("/hotel-chains")
    public ResponseEntity<?> getHotelChains() {
        List<HotelChain> hotelChainsFound = hotelChainService.findAll();

        if (hotelChainsFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe la cadena de hoteles"));
        }
        List<HotelChainsResponseDTO> hotelChainsResponseDTO = hotelChainService.converListToDTOList(hotelChainsFound);

        return ResponseEntity.ok(new ResponseDTO<>(hotelChainsResponseDTO, "Consulta a cadenas de hoteles exitosa"));
    }

    @GetMapping("/hotel-chains/{id}")
    public ResponseEntity<?> getHotelChain(@PathVariable Long id) {
        HotelChain hotelChainFound = hotelChainService.findById(id);

        if (hotelChainFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe la cadena de hoteles"));
        }
        HotelChainsResponseDTO hotelChainsResponseDTO = hotelChainService.convertToDTO(hotelChainFound);
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainsResponseDTO, "Cadena de hotel encontrada con exito"));
    }

    @PostMapping("/hotel-chains")
    public ResponseEntity<?> saveHotelChain(@RequestBody CreateUpdateHotelChainDTO newHotelChain) {
        HotelChain hotelChainCreated = hotelChainService.save(newHotelChain);
        HotelChainsResponseDTO savedHotelChainDTO = hotelChainService.convertToDTO(hotelChainCreated);

        return ResponseEntity.ok().body(new ResponseDTO<>(savedHotelChainDTO, "Cadena de hotel creada con exito"));
    }

    @PutMapping("/hotel-chains/{id}")
    public ResponseEntity<?> updateHotelChain(@PathVariable Long id, @RequestBody CreateUpdateHotelChainDTO updateHotelChainDTO) {
        HotelChain hotelChainUpdate = hotelChainService.updateHotelChain(id, updateHotelChainDTO);
        if (hotelChainUpdate == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Cadena de hoteles no existe"));
        }
        HotelChainsResponseDTO updatedHotelChainDTO = hotelChainService.convertToDTO(hotelChainUpdate);
        return ResponseEntity.ok().body(new ResponseDTO<>(updatedHotelChainDTO, "Cadena de hotel editada con exito"));

    }

    @DeleteMapping("/hotel-chains/{id}")
    public ResponseEntity<?> deleteHotelChain(@PathVariable Long id) {
        HotelChain hotelChainDeleted = hotelChainService.deleteById(id);
        if (hotelChainDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Cadena de hotel no encontrado"));
        }
        HotelChainsResponseDTO deletedHotelChainDTO = hotelChainService.convertToDTO(hotelChainDeleted);
        return ResponseEntity.ok().body(new ResponseDTO<>(deletedHotelChainDTO, "Cadena de hotel borrada con exito"));
    }


    //--------------------------------------HOTEL BRANCH--------------------------------------
    @GetMapping("/hotel-branches")
    public ResponseEntity<?> getHotelBranches() {
        return ResponseEntity.ok(new ResponseDTO<>(hotelBranchService.findAll(), "Consulta a sucursales de hoteles exitosa"));
    }

    @GetMapping("/hotel-branches/{id}")
    public ResponseEntity<?> getHotelBranches(@PathVariable Long id) {
        HotelBranch hotelBranchFound = hotelBranchService.findById(id);
        if (hotelBranchFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe el hotel"));
        }

        return ResponseEntity.ok().body(new ResponseDTO<>(hotelBranchFound, "Sucursal de hotel encontrada con exito"));
    }

    @PostMapping("/hotel-branches")
    public ResponseEntity<?> saveHotelBranch(@RequestBody CreateHotelBranchDTO newHotelBranch) throws ParseException {
        HotelBranch hotelBranchCreated = hotelBranchService.save(newHotelBranch);

        return ResponseEntity.ok().body(new ResponseDTO<>(hotelBranchCreated, "Sucursal de hotel creada con exito"));
    }

    @PutMapping("/hotel-branches/{id}")
    public ResponseEntity<?> updateHotelBranch(@PathVariable Long id, @RequestBody UpdateHotelBranchDTO updateHotelBranchDTO) {
        HotelBranch hotelBranchUpdated = hotelBranchService.updateHotelBranch(id, updateHotelBranchDTO);
        if (hotelBranchUpdated == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Sucursal de hoteles no existe"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelBranchUpdated, "Sucursal de hotel editada con exito"));

    }

    @DeleteMapping("/hotel-branches/{id}")
    public ResponseEntity<?> deleteHotelBranch(@PathVariable Long id) {
        HotelBranch hotelBranchDeleted = hotelBranchService.deleteById(id);
        if (hotelBranchDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Sucursal de hotel no encontrado"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelBranchDeleted, "Sucursal de hotel borrada con exito"));
    }




}
