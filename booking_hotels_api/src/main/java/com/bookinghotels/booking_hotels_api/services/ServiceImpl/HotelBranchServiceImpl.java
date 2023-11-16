package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateHotelBranchDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranchType;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.repositories.HotelBranchRepository;
import com.bookinghotels.booking_hotels_api.services.IService.HotelBranchService;
import com.bookinghotels.booking_hotels_api.services.IService.HotelBranchTypeService;
import com.bookinghotels.booking_hotels_api.services.IService.HotelChainService;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelBranchServiceImpl implements HotelBranchService {
    @Autowired
    HotelBranchRepository hotelBranchRepository;

    @Autowired
    HotelChainService hotelChainService;

    @Autowired
    HotelBranchTypeService hotelBranchTypeService;


    @Override
    public List<HotelBranch> findAll() {
        return hotelBranchRepository.findAll();
    }

    @Override
    public HotelBranch save(CreateHotelBranchDTO newHotelBranchDTO) throws ParseException {
        HotelBranch newHotelBranch = new HotelBranch();
        newHotelBranch.setAddress(newHotelBranchDTO.getAddress());
        newHotelBranch.setName(newHotelBranchDTO.getName());
        Double latitude = newHotelBranchDTO.getLatitude();
        Double longitude = newHotelBranchDTO.getLongitude();

        newHotelBranch.setLocation(createLocation(latitude,longitude));

        HotelChain chain = hotelChainService.findById(newHotelBranchDTO.getHotelChainId());
        HotelBranchType branch = hotelBranchTypeService.findById(newHotelBranchDTO.getHotelBranchTypeId());

        newHotelBranch.setHotelChain(chain);
        newHotelBranch.setHotelBranchType(branch);

        newHotelBranch = hotelBranchRepository.save(newHotelBranch);


        return newHotelBranch;
    }

    @Override
    public HotelBranch findById(Long id) {
        return hotelBranchRepository.findById(id).orElse(null);
    }

    @Override
    public HotelBranch deleteById(Long id) {
        HotelBranch hotelBranchDeleted = hotelBranchRepository.findById(id).orElse(null);
        if (hotelBranchDeleted == null){
            return null;
        }
        hotelBranchDeleted.setDeleted(true);
        hotelBranchDeleted = hotelBranchRepository.save(hotelBranchDeleted);

        return hotelBranchDeleted;
    }

    @Override
    public HotelBranch updateHotelBranch(Long id, UpdateHotelBranchDTO updateHotelBranchDTO) {
        HotelBranch hotelBranch = findById(id);
        if (hotelBranch == null){
            return null;
        }
        hotelBranch.setName(updateHotelBranchDTO.getName());
        hotelBranch.setAddress(updateHotelBranchDTO.getAddress());

        hotelBranch = hotelBranchRepository.save(hotelBranch);

        return hotelBranch;
    }

    @Override
    public Point createLocation(Double latitude, Double longitude) throws ParseException {
        String  location2 =  "POINT (" + latitude + " " + longitude + ")" ;
        return ( (Point)wktToGeometry(location2));
    }

    public Geometry wktToGeometry(String wellKnownText) throws ParseException {
        return new WKTReader().read(wellKnownText);
    }

}
