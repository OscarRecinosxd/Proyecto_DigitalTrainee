package com.bookinghotels.booking_hotels_api.utils;

import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelChainResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import org.springframework.stereotype.Component;

@Component
public class ConvertToDTO {
    public HotelChainResponseDTO convertToDTO(HotelChain hotelChain) {
        HotelChainResponseDTO hotelChainResponseDTO = new HotelChainResponseDTO();
        hotelChainResponseDTO.setId(hotelChain.getId());
        hotelChainResponseDTO.setName(hotelChain.getName());
        hotelChainResponseDTO.setDeleted(hotelChain.isDeleted());
        hotelChainResponseDTO.setHotelBranches(hotelChain.getHotel_branches());

        return hotelChainResponseDTO;
    }
}
