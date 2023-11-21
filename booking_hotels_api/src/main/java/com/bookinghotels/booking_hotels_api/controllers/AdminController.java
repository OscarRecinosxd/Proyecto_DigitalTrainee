package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.*;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelBranchResponseDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelChainResponseDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.UserResponseDTO;
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
        List<User> users = userService.findAll();
        if (users == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existen usuarios"));
        }
        List<UserResponseDTO> userResponseDTOS = userService.converListToDTOList(users);

        return ResponseEntity.ok(new ResponseDTO<>(userResponseDTOS, "Consulta a usuarios exitosa"));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        User userFound = userService.findById(id);
        if (userFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe el usuario"));
        }
        UserResponseDTO userResponseDTO = userService.convertToDTO(userFound);

        return ResponseEntity.ok().body(new ResponseDTO<>(userResponseDTO, "Usuario encontrado con exito"));
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody CreateUserDTO newUser) {
        User userCreated = userService.save(newUser);
        if (userCreated == null) {
            return ResponseEntity.internalServerError().body(new ResponseDTO<>(null, "Hubo un error"));
        }

        UserResponseDTO userResponseDTO = userService.convertToDTO(userCreated);
        return ResponseEntity.ok().body(new ResponseDTO<>(userResponseDTO, "Usuario creado con exito"));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO) {
        User userUpdated = userService.updateUser(id, updateUserDTO);
        if (userUpdated == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Usuario no existe"));
        }
        UserResponseDTO userResponseDTO = userService.convertToDTO(userUpdated);

        return ResponseEntity.ok().body(new ResponseDTO<>(userResponseDTO, "Usuario editado con exito"));

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User userDeleted = userService.deleteById(id);
        if (userDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Usuario no encontrado"));
        }
        UserResponseDTO userResponseDTO = userService.convertToDTO(userDeleted);

        return ResponseEntity.ok().body(new ResponseDTO<>(userResponseDTO, "Usuario borrado con exito"));
    }

    // ----------------------------------HOTEL CHAIN-----------------------------------------------

    @GetMapping("/hotel-chains")
    public ResponseEntity<?> getHotelChains() {
        List<HotelChain> hotelChainsFound = hotelChainService.findAll();
        if (hotelChainsFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No hay cadenas de hoteles"));
        }
        List<HotelChainResponseDTO> hotelChainsResponseDTO = hotelChainService.converListToDTOList(hotelChainsFound);

        return ResponseEntity.ok(new ResponseDTO<>(hotelChainsResponseDTO, "Consulta a cadenas de hoteles exitosa"));
    }

    @GetMapping("/hotel-chains/{id}")
    public ResponseEntity<?> getHotelChain(@PathVariable Long id) {
        HotelChain hotelChainFound = hotelChainService.findById(id);

        if (hotelChainFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe la cadena de hoteles"));
        }
        HotelChainResponseDTO hotelChainResponseDTO = hotelChainService.convertToDTO(hotelChainFound);
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainResponseDTO, "Cadena de hotel encontrada con exito"));
    }

    @PostMapping("/hotel-chains")
    public ResponseEntity<?> saveHotelChain(@RequestBody CreateUpdateHotelChainDTO newHotelChain) {
        HotelChain hotelChainCreated = hotelChainService.save(newHotelChain);
        if (hotelChainCreated == null) {
            return ResponseEntity.internalServerError().body(new ResponseDTO<>(null, "Hubo un error"));
        }
        HotelChainResponseDTO savedHotelChainDTO = hotelChainService.convertToDTO(hotelChainCreated);

        return ResponseEntity.ok().body(new ResponseDTO<>(savedHotelChainDTO, "Cadena de hotel creada con exito"));
    }

    @PutMapping("/hotel-chains/{id}")
    public ResponseEntity<?> updateHotelChain(@PathVariable Long id, @RequestBody CreateUpdateHotelChainDTO updateHotelChainDTO) {
        HotelChain hotelChainUpdate = hotelChainService.updateHotelChain(id, updateHotelChainDTO);
        if (hotelChainUpdate == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Cadena de hoteles no existe"));
        }
        HotelChainResponseDTO updatedHotelChainDTO = hotelChainService.convertToDTO(hotelChainUpdate);
        return ResponseEntity.ok().body(new ResponseDTO<>(updatedHotelChainDTO, "Cadena de hotel editada con exito"));

    }

    @DeleteMapping("/hotel-chains/{id}")
    public ResponseEntity<?> deleteHotelChain(@PathVariable Long id) {
        HotelChain hotelChainDeleted = hotelChainService.deleteById(id);
        if (hotelChainDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Cadena de hotel no encontrado"));
        }
        HotelChainResponseDTO deletedHotelChainDTO = hotelChainService.convertToDTO(hotelChainDeleted);
        return ResponseEntity.ok().body(new ResponseDTO<>(deletedHotelChainDTO, "Cadena de hotel borrada con exito"));
    }


    //--------------------------------------HOTEL BRANCH--------------------------------------
    @GetMapping("/hotel-branches")
    public ResponseEntity<?> getHotelBranches() {
        List<HotelBranch> hotelBranchesFound = hotelBranchService.findAll();
        if (hotelBranchesFound == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No hay sucursales de hoteles"));
        }
        List<HotelBranchResponseDTO> hotelBranchResponseDTOS = hotelBranchService.converListToDTOList(hotelBranchesFound);
        return ResponseEntity.ok(new ResponseDTO<>(hotelBranchResponseDTOS, "Consulta a sucursales de hoteles exitosa"));
    }

    @GetMapping("/hotel-branches/{id}")
    public ResponseEntity<?> getHotelBranches(@PathVariable Long id) {
        HotelBranch hotelBranchFound = hotelBranchService.findById(id);
        if (hotelBranchFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe el hotel"));
        }
        HotelBranchResponseDTO hotelBranchResponseDTO = hotelBranchService.convertToDTO(hotelBranchFound);

        return ResponseEntity.ok().body(new ResponseDTO<>(hotelBranchResponseDTO, "Sucursal de hotel encontrada con exito"));
    }

    @PostMapping("/hotel-branches")
    public ResponseEntity<?> saveHotelBranch(@RequestBody CreateHotelBranchDTO newHotelBranch) throws ParseException {
        HotelBranch hotelBranchCreated = hotelBranchService.save(newHotelBranch);
        if (hotelBranchCreated == null) {
            return ResponseEntity.internalServerError().body(new ResponseDTO<>(null, "Hubo un error"));
        }
        HotelBranchResponseDTO hotelBranchResponseDTO = hotelBranchService.convertToDTO(hotelBranchCreated);

        return ResponseEntity.ok().body(new ResponseDTO<>(hotelBranchResponseDTO, "Sucursal de hotel creada con exito"));
    }

    @PutMapping("/hotel-branches/{id}")
    public ResponseEntity<?> updateHotelBranch(@PathVariable Long id, @RequestBody UpdateHotelBranchDTO updateHotelBranchDTO) {
        HotelBranch hotelBranchUpdated = hotelBranchService.updateHotelBranch(id, updateHotelBranchDTO);
        if (hotelBranchUpdated == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Sucursal de hoteles no existe"));
        }
        HotelBranchResponseDTO hotelBranchResponseDTO = hotelBranchService.convertToDTO(hotelBranchUpdated);
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelBranchResponseDTO, "Sucursal de hotel editada con exito"));

    }

    @DeleteMapping("/hotel-branches/{id}")
    public ResponseEntity<?> deleteHotelBranch(@PathVariable Long id) {
        HotelBranch hotelBranchDeleted = hotelBranchService.deleteById(id);
        if (hotelBranchDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Sucursal de hotel no encontrado"));
        }
        HotelBranchResponseDTO hotelBranchResponseDTO = hotelBranchService.convertToDTO(hotelBranchDeleted);
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelBranchResponseDTO, "Sucursal de hotel borrada con exito"));
    }




}
