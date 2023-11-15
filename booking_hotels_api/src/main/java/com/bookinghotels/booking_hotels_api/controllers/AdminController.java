package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUpdateHotelChainDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.CreateUserDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateUserDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.models.entities.User;
import com.bookinghotels.booking_hotels_api.services.IService.HotelChainService;
import com.bookinghotels.booking_hotels_api.services.IService.UserService;
import com.bookinghotels.booking_hotels_api.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    HotelChainService hotelChainService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(new ResponseDTO<>(userService.findAll(), "Usuarios encontrados con exito"));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        User userFound = userService.findById(id);
        if(userFound == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null,"No existe el usuario"));
        }

        return ResponseEntity.ok().body(new ResponseDTO<>(userFound,"Usuario encontrado con exito"));
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody CreateUserDTO newUser){
        User userCreated = userService.save(newUser);

        return ResponseEntity.ok().body(new ResponseDTO<>(userCreated, "Usuario creado con exito"));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO){
        User userUpdated = userService.updateUser(id, updateUserDTO);
        if(userUpdated == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null,"Usuario no existe"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(userUpdated,"Usuario editado con exito"));

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        User userDeleted = userService.deleteById(id);
        if(userDeleted == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null,"Usuario no encontrado"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(userDeleted,"Usuario borrado con exito"));
    }

    // ----------------------------------HOTEL CHAIN-----------------------------------------------

    @GetMapping("/hotel-chains")
    public ResponseEntity<?> getHotelChains(){
        return ResponseEntity.ok(new ResponseDTO<>(hotelChainService.findAll(), "Cadenas de hoteles encontrados con exito"));
    }

    @GetMapping("/hotel-chains/{id}")
    public ResponseEntity<?> getHotelChain(@PathVariable Long id){
        HotelChain hotelChainFound = hotelChainService.findById(id);
        if(hotelChainFound == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null,"No existe la cadena de hoteles"));
        }

        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainFound,"Cadena de hotel encontrada con exito"));
    }

    @PostMapping("/hotel-chains")
    public ResponseEntity<?> saveHotelChain(@RequestBody CreateUpdateHotelChainDTO newHotelChain){
        HotelChain hotelChainCreated = hotelChainService.save(newHotelChain);

        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainCreated, "Cadena de hotel creada con exito"));
    }

    @PutMapping("/hotel-chains/{id}")
    public ResponseEntity<?> updateHotelChain(@PathVariable Long id, @RequestBody CreateUpdateHotelChainDTO updateHotelChainDTO){
        HotelChain hotelChainUpdate = hotelChainService.updateHotelChain(id, updateHotelChainDTO);
        if(hotelChainUpdate == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null,"Cadena de hoteles no existe"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainUpdate,"Cadena de hotel editada con exito"));

    }

    @DeleteMapping("/hotel-chains/{id}")
    public ResponseEntity<?> deleteHotelChain(@PathVariable Long id){
        HotelChain hotelChainDeleted = hotelChainService.deleteById(id);
        if(hotelChainDeleted == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null,"Cadena de hotel no encontrado"));
        }
        return ResponseEntity.ok().body(new ResponseDTO<>(hotelChainDeleted,"Cadena de hotel borrada con exito"));
    }




}
