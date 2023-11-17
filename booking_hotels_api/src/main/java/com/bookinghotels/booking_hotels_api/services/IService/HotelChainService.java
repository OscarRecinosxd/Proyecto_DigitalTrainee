package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUpdateHotelChainDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelChainResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;

import java.util.List;

public interface HotelChainService {
    List<HotelChain> findAll();

    HotelChain save(CreateUpdateHotelChainDTO newHotelChain);

    HotelChain findById(Long id);

    HotelChain deleteById(Long id);

    HotelChain updateHotelChain(Long id, CreateUpdateHotelChainDTO updateHotelChainDTO);

    HotelChainResponseDTO convertToDTO(HotelChain hotelChain);

    List<HotelChainResponseDTO> converListToDTOList(List<HotelChain> hotelChains);
}
