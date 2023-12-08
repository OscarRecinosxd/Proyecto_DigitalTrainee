package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.entities.Room;
import com.bookinghotels.booking_hotels_api.repositories.RoomRepository;
import com.bookinghotels.booking_hotels_api.services.IService.HotelBranchService;
import com.bookinghotels.booking_hotels_api.services.IService.RoomTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceImplTest {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelBranchService hotelBranchService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Test
    void findAll() {
        RoomServiceImpl roomService = new RoomServiceImpl(roomRepository, hotelBranchService, roomTypeService);
        List<Room> allRooms = roomService.findAll();
        assertNotNull(allRooms);
    }

    @Test
    void findById() {
        RoomServiceImpl roomService = new RoomServiceImpl(roomRepository, hotelBranchService, roomTypeService);
        Long roomId = 1L;
        Room foundRoom = roomService.findById(roomId);
        assertNotNull(foundRoom);
    }

    @Test
    void deleteById() {
        RoomServiceImpl roomService = new RoomServiceImpl(roomRepository, hotelBranchService, roomTypeService);
        Long roomIdToDelete = 1L;
        Room deletedRoom = roomService.deleteById(roomIdToDelete);
        assertNotNull(deletedRoom);
    }

}