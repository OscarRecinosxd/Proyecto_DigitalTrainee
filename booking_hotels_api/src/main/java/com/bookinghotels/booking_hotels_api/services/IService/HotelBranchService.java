package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;


import java.util.List;

public interface HotelBranchService {
    List<HotelBranch> findAll();

    HotelBranch save(CreateHotelBranchDTO newHotelBranch) throws ParseException;

    HotelBranch findById(Long id);

    HotelBranch deleteById(Long id);

    HotelBranch updateHotelBranch(Long id, UpdateHotelBranchDTO updateHotelBranchDTO);

    Point createLocation(Double latitude, Double longitude) throws ParseException;
}
