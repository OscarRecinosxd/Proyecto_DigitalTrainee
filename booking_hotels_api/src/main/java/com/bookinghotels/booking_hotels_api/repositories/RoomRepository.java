package com.bookinghotels.booking_hotels_api.repositories;

import com.bookinghotels.booking_hotels_api.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

