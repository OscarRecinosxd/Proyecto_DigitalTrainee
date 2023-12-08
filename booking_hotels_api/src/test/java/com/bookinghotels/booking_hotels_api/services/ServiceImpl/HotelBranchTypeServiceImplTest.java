package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.HotelBranchType;
import com.bookinghotels.booking_hotels_api.repositories.HotelBranchTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelBranchTypeServiceImplTest {

    @Autowired
    private HotelBranchTypeRepository hotelBranchTypeRepository;

    @Test
    void findAll() {
        HotelBranchTypeServiceImpl hotelBranchTypeService = new HotelBranchTypeServiceImpl(hotelBranchTypeRepository);
        List<HotelBranchType> allBranchTypes = hotelBranchTypeService.findAll();
        assertNotNull(allBranchTypes);
    }

    @Test
    void findById() {
        HotelBranchTypeServiceImpl hotelBranchTypeService = new HotelBranchTypeServiceImpl(hotelBranchTypeRepository);
        Long typeId = 1L;
        HotelBranchType branchType = hotelBranchTypeService.findById(typeId);
        assertNotNull(branchType);
    }
}