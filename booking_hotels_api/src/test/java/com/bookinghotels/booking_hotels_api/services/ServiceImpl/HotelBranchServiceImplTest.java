package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.repositories.HotelBranchRepository;
import com.bookinghotels.booking_hotels_api.services.IService.HotelBranchTypeService;
import com.bookinghotels.booking_hotels_api.services.IService.HotelChainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelBranchServiceImplTest {

    @Autowired
    private HotelBranchRepository hotelBranchRepository;

    @Autowired
    private HotelChainService hotelChainService;

    @Autowired
    private HotelBranchTypeService hotelBranchTypeService;

    @Test
    void findAll() {
        HotelBranchServiceImpl hotelBranchService = new HotelBranchServiceImpl(
                hotelBranchRepository, hotelChainService, hotelBranchTypeService
        );
        List<HotelBranch> allBranches = hotelBranchService.findAll();
        assertNotNull(allBranches);
    }


    @Test
    void findById() {
        HotelBranchServiceImpl hotelBranchService = new HotelBranchServiceImpl(
                hotelBranchRepository, hotelChainService, hotelBranchTypeService
        );
        Long branchId = 1L;
        HotelBranch foundBranch = hotelBranchService.findById(branchId);
        assertNotNull(foundBranch);
    }

    @Test
    void deleteById() {
        HotelBranchServiceImpl hotelBranchService = new HotelBranchServiceImpl(
                hotelBranchRepository, hotelChainService, hotelBranchTypeService
        );
        Long branchIdToDelete = 1L;
        HotelBranch deletedBranch = hotelBranchService.deleteById(branchIdToDelete);
        assertNotNull(deletedBranch);
    }

    @Test
    void updateHotelBranch() {
        HotelBranchServiceImpl hotelBranchService = new HotelBranchServiceImpl(
                hotelBranchRepository, hotelChainService, hotelBranchTypeService
        );
        Long branchIdToUpdate = 1L;
        UpdateHotelBranchDTO updateHotelBranchDTO = new UpdateHotelBranchDTO();

        HotelBranch updatedBranch = hotelBranchService.updateHotelBranch(branchIdToUpdate, updateHotelBranchDTO);
        assertNotNull(updatedBranch);
    }
}