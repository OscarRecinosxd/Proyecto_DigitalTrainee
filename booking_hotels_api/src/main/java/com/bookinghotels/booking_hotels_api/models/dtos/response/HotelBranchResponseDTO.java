package com.bookinghotels.booking_hotels_api.models.dtos.response;

import com.bookinghotels.booking_hotels_api.models.entities.HotelBranchType;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import lombok.Data;

@Data
public class HotelBranchResponseDTO {
    private HotelChain hotelChain;
    private HotelBranchType hotelBranchType;
    private String name;
    private String address;
    private boolean isDeleted;
}
