package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUpdateHotelChainDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranchType;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;

import java.util.List;

public interface HotelBranchTypeService {
    List<HotelBranchType> findAll();
    HotelBranchType findById(Long id);
}
