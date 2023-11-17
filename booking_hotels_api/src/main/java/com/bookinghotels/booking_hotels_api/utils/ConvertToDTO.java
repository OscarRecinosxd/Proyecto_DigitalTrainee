package com.bookinghotels.booking_hotels_api.utils;

import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelChainsResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import org.springframework.stereotype.Component;

@Component
public class ConvertToDTO {
    public HotelChainsResponseDTO convertToDTO(HotelChain hotelChain) {
        HotelChainsResponseDTO hotelChainsResponseDTO = new HotelChainsResponseDTO();
        hotelChainsResponseDTO.setId(hotelChain.getId());
        hotelChainsResponseDTO.setName(hotelChain.getName());
        hotelChainsResponseDTO.setDeleted(hotelChain.isDeleted());
        hotelChainsResponseDTO.setHotelBranches(hotelChain.getHotel_branches());

        return hotelChainsResponseDTO;
    }
}
