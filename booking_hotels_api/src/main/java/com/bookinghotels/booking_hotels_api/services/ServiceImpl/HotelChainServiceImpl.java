package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUpdateHotelChainDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelChainResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.repositories.HotelChainRepository;
import com.bookinghotels.booking_hotels_api.services.IService.HotelChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelChainServiceImpl implements HotelChainService {

    private final HotelChainRepository hotelChainRepository;

    @Autowired
    public HotelChainServiceImpl(HotelChainRepository hotelChainRepository) {
        this.hotelChainRepository = hotelChainRepository;
    }

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
        HotelChain newHotelChain = hotelChainRepository.findById(id).orElse(null);
        if (newHotelChain == null){return null;}

        return newHotelChain;
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

    @Override
    public HotelChainResponseDTO convertToDTO(HotelChain hotelChain) {
        HotelChainResponseDTO hotelChainResponseDTO = new HotelChainResponseDTO();
        hotelChainResponseDTO.setId(hotelChain.getId());
        hotelChainResponseDTO.setName(hotelChain.getName());
        hotelChainResponseDTO.setDeleted(hotelChain.isDeleted());
        hotelChainResponseDTO.setHotelBranches(hotelChain.getHotel_branches());

        return hotelChainResponseDTO;
    }

    @Override
    public List<HotelChainResponseDTO> converListToDTOList(List<HotelChain> hotelChains) {
        List<HotelChainResponseDTO> hotelChainsResponseDTOS = new ArrayList<>();
        hotelChains.forEach(hotelChain -> hotelChainsResponseDTOS.add(convertToDTO(hotelChain)));

        return hotelChainsResponseDTOS;
    }

}
