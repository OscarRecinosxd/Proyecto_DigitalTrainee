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
    }

    @Test
    void save() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        CreateUserDTO newUserDTO = new CreateUserDTO();

        User savedUser = userService.save(newUserDTO);
        assertNotNull(savedUser);
    }

    @Test
    void findById() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        Long userId = 1L;
        User foundUser = userService.findById(userId);
        assertNotNull(foundUser);
    }

    @Test
    void deleteById() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        Long userIdToDelete = 1L;
        User deletedUser = userService.deleteById(userIdToDelete);
        assertNotNull(deletedUser);
    }

    @Test
    void updateUser() {
        UserServiceImpl userService = new UserServiceImpl(userRepository, roleService);
        Long userIdToUpdate = 1L;
        UpdateUserDTO updateUserDTO = new UpdateUserDTO();

        User updatedUser = userService.updateUser(userIdToUpdate, updateUserDTO);
        assertNotNull(updatedUser);
    }
}