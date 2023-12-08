package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.Role;
import com.bookinghotels.booking_hotels_api.repositories.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceImplTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void getAdminRole() {
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);
        Role adminRole = roleService.getAdminRole();
        assertNotNull(adminRole);
    }

    @Test
    void getClientRole() {
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);
        Role clientRole = roleService.getClientRole();
        assertNotNull(clientRole);
    }

    @Test
    void getHotelOwnerRole() {
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);
        Role hotelOwnerRole = roleService.getHotelOwnerRole();
        assertNotNull(hotelOwnerRole);
    }
}