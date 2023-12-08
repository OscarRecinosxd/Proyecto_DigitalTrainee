package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelBranchResponseDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelChainResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;



import java.util.List;

public interface HotelBranchService {
    List<HotelBranch> findAll();

    HotelBranch save(CreateHotelBranchDTO newHotelBranch);

    HotelBranch findById(Long id);

    HotelBranch deleteById(Long id);

    HotelBranch updateHotelBranch(Long id, UpdateHotelBranchDTO updateHotelBranchDTO);

    HotelBranchResponseDTO convertToDTO(HotelBranch hotelBranch);

    List<HotelBranchResponseDTO> converListToDTOList(List<HotelBranch> hotelBranches);

}
