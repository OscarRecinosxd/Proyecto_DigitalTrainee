package com.bookinghotels.booking_hotels_api.controllers;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUserDTO;
import com.bookinghotels.booking_hotels_api.models.entities.User;
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

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(new ResponseDTO<>(userService.findAll(), "Usuarios encontrados con exito"));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        User userFound =userService.findById(id);
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

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        User userDeleted = userService.deleteById(id);
        if(userDeleted == null){
            return ResponseEntity.status(404).body(new ResponseDTO<>(null,"Usuario no encontrado"));
        }
        ResponseDTO<User> responseDTO = new ResponseDTO<>(userDeleted,"Usuario borrado con exito");
        System.out.println(responseDTO);
        return ResponseEntity.ok().body(responseDTO);
    }


}
