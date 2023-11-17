package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.CreateUpdateHotelChainDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.models.entities.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room save(CreateRoomDTO newHotelChain);

    Room findById(Long id);

    Room deleteById(Long id);

    Room updateRoom(Long id, UpdateRoomDTO updateRoomDTO);
}
