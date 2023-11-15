package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.Role;
import com.bookinghotels.booking_hotels_api.repositories.RoleRepository;
import com.bookinghotels.booking_hotels_api.services.IService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getAdminRole() {
        return roleRepository.findById(1L).orElse(null);
    }

    @Override
    public Role getClientRole() {
        return roleRepository.findById(2L).orElse(null);
    }

    @Override
    public Role getHotelOwnerRole() {
        return roleRepository.findById(3L).orElse(null);
    }
}
