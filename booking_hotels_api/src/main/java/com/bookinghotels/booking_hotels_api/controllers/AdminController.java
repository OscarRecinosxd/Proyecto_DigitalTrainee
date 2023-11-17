package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.*;
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

@RestController
@RequestMapping("/admin")
public class AdminController {

    /*

    INSERT INTO roles (id,description,name) VALUES (1,'Rol de admin','Admins'),(2,'Rol de consumidor','Costumer'),
(3,'Rol de hotel owner','Hotel Owner');


INSERT INTO hotel_branch_types(id,description,name) VALUES (1,'Ideales para extranjeros','Turistico'),
(2,'baratos a largo plazo','Larga estadia'),
(3,'para  eventos','Eventos'),
(4,'Para pasar el rato','Moteles');

INSERT INTO hotel_chains(id,description,is_deleted,name) VALUES (1,'asd',false,'Decameron'),(2,'xd',false,'Intercontinental');

     */
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
        return ResponseEntity.ok(new ResponseDTO<>(hotelChainService.findAll(), "Consulta a cadenas de hoteles exitosa"));
    }

    @GetMapping("/hotel-chains/{id}")
    public ResponseEntity<?> getHotelChain(@PathVariable Long id) {
        HotelChain hotelChainFound = hotelChainService.findById(id);
        if (hotelChainFound == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "No existe la cadena de hoteles"));
        }

        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainFound, "Cadena de hotel encontrada con exito"));
    }

    @PostMapping("/hotel-chains")
    public ResponseEntity<?> saveHotelChain(@RequestBody CreateUpdateHotelChainDTO newHotelChain) {
        HotelChain hotelChainCreated = hotelChainService.save(newHotelChain);

        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainCreated, "Cadena de hotel creada con exito"));
    }

    @PutMapping("/hotel-chains/{id}")
    public ResponseEntity<?> updateHotelChain(@PathVariable Long id, @RequestBody CreateUpdateHotelChainDTO updateHotelChainDTO) {
        HotelChain hotelChainUpdate = hotelChainService.updateHotelChain(id, updateHotelChainDTO);
        if (hotelChainUpdate == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Cadena de hoteles no existe"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainUpdate, "Cadena de hotel editada con exito"));

    }

    @DeleteMapping("/hotel-chains/{id}")
    public ResponseEntity<?> deleteHotelChain(@PathVariable Long id) {
        HotelChain hotelChainDeleted = hotelChainService.deleteById(id);
        if (hotelChainDeleted == null) {
            return ResponseEntity.status(404).body(new ResponseDTO<>(null, "Cadena de hotel no encontrado"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainDeleted, "Cadena de hotel borrada con exito"));
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
