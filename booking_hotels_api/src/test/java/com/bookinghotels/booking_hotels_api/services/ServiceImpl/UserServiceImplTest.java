package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUserDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateUserDTO;
import com.bookinghotels.booking_hotels_api.models.entities.User;
import com.bookinghotels.booking_hotels_api.repositories.UserRepository;
import com.bookinghotels.booking_hotels_api.services.IService.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Test
    void findAll() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        List<User> allUsers = userService.findAll();
        assertNotNull(allUsers);
        // Add more assertions as needed
    }

    @Test
    void save() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        CreateUserDTO newUserDTO = new CreateUserDTO();
        // Set properties of newUserDTO with test data

        User savedUser = userService.save(newUserDTO);
        assertNotNull(savedUser);
        // Add more assertions as needed
    }

    @Test
    void findById() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        Long userId = 1L; // Replace with an actual user ID from your test data
        User foundUser = userService.findById(userId);
        assertNotNull(foundUser);
        // Add more assertions as needed
    }

    @Test
    void deleteById() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        Long userIdToDelete = 1L; // Replace with an actual user ID from your test data
        User deletedUser = userService.deleteById(userIdToDelete);
        assertNotNull(deletedUser);
        // Add more assertions as needed
    }

    @Test
    void updateUser() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        Long userIdToUpdate = 1L; // Replace with an actual user ID from your test data
        UpdateUserDTO updateUserDTO = new UpdateUserDTO();
        // Set properties of updateUserDTO with test data

        User updatedUser = userService.updateUser(userIdToUpdate, updateUserDTO);
        assertNotNull(updatedUser);
        // Add more assertions as needed
    }
}