package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUpdateHotelChainDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.repositories.HotelChainRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelChainServiceImplTest {

    @Autowired
    private HotelChainRepository hotelChainRepository;

    @Test
    void findAll() {
        HotelChainServiceImpl hotelChainService = new HotelChainServiceImpl(hotelChainRepository);
        List<HotelChain> allChains = hotelChainService.findAll();
        assertNotNull(allChains);
    }

    @Test
    void save() {
        HotelChainServiceImpl hotelChainService = new HotelChainServiceImpl(hotelChainRepository);
        CreateUpdateHotelChainDTO newHotelChainDTO = new CreateUpdateHotelChainDTO();

        HotelChain savedChain = hotelChainService.save(newHotelChainDTO);
        assertNotNull(savedChain);
    }

    @Test
    void findById() {
        HotelChainServiceImpl hotelChainService = new HotelChainServiceImpl(hotelChainRepository);
        Long chainId = 1L;
        HotelChain foundChain = hotelChainService.findById(chainId);
        assertNotNull(foundChain);
    }

    @Test
    void deleteById() {
        HotelChainServiceImpl hotelChainService = new HotelChainServiceImpl(hotelChainRepository);
        Long chainIdToDelete = 1L;
        HotelChain deletedChain = hotelChainService.deleteById(chainIdToDelete);
        assertNotNull(deletedChain);
    }

    @Test
    void updateHotelChain() {
        HotelChainServiceImpl hotelChainService = new HotelChainServiceImpl(hotelChainRepository);
        Long chainIdToUpdate = 1L;
        CreateUpdateHotelChainDTO updateHotelChainDTO = new CreateUpdateHotelChainDTO();

        HotelChain updatedChain = hotelChainService.updateHotelChain(chainIdToUpdate, updateHotelChainDTO);
        assertNotNull(updatedChain);
    }
}