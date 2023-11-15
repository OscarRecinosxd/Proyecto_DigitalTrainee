package com.bookinghotels.booking_hotels_api.repositories;

import com.bookinghotels.booking_hotels_api.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
