package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUpdateHotelChainDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.repositories.HotelChainRepository;
import com.bookinghotels.booking_hotels_api.services.IService.HotelChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelChainServiceImpl implements HotelChainService {

    @Autowired
    private HotelChainRepository hotelChainRepository;
    @Override
    public List<HotelChain> findAll() {
        return hotelChainRepository.findAll();
    }

    @Override
    public HotelChain save(CreateUpdateHotelChainDTO newHotelChainDTO) {
        HotelChain newHotelChain = new HotelChain();
        newHotelChain.setName(newHotelChainDTO.getName());
        newHotelChain.setDescription(newHotelChainDTO.getDescription());
        newHotelChain = hotelChainRepository.save(newHotelChain);
        return newHotelChain;
    }

    @Override
    public HotelChain findById(Long id) {
        return hotelChainRepository.findById(id).orElse(null);
    }

    @Override
    public HotelChain deleteById(Long id) {
        HotelChain deletedHotelChain = findById(id);
        if(deletedHotelChain == null){
            return null;
        }
        deletedHotelChain.setDeleted(true);
        deletedHotelChain = hotelChainRepository.save(deletedHotelChain);

        return deletedHotelChain;
    }

    @Override
    public HotelChain updateHotelChain(Long id, CreateUpdateHotelChainDTO updateHotelChainDTO) {
        HotelChain updatedHotelChain = findById(id);
        if(updatedHotelChain == null){
            return null;
        }
        updatedHotelChain.setName(updateHotelChainDTO.getName());
        updatedHotelChain.setDescription(updateHotelChainDTO.getDescription());

        updatedHotelChain = hotelChainRepository.save(updatedHotelChain);
        return updatedHotelChain;
    }
}
