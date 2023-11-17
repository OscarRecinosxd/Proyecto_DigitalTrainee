package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.entities.HotelBranchType;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.repositories.HotelBranchTypeRepository;
import com.bookinghotels.booking_hotels_api.services.IService.HotelBranchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelBranchTypeServiceImpl implements HotelBranchTypeService {
    @Autowired
    HotelBranchTypeRepository hotelBranchTypeRepository;

    @Override
    public List<HotelBranchType> findAll() {
        return hotelBranchTypeRepository.findAll();
    }

    @Override
    public HotelBranchType findById(Long id) {
        return hotelBranchTypeRepository.findById(id).orElse(null);
    }
}
