package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.RoomType;
import com.bookinghotels.booking_hotels_api.repositories.RoomTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomTypeServiceImplTest {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Test
    void findById() {
        RoomTypeServiceImpl roomTypeService = new RoomTypeServiceImpl(roomTypeRepository);
        Long roomTypeId = 1L;
        RoomType foundRoomType = roomTypeService.findById(roomTypeId);
        assertNotNull(foundRoomType);
    }
}