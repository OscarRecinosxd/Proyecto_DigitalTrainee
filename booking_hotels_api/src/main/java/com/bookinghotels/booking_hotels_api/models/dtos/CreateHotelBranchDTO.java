package com.bookinghotels.booking_hotels_api.models.dtos;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
public class CreateHotelBranchDTO {
    private Long hotelChainId;
    private Long hotelBranchTypeId;
    private String name;
    private String address;
    //13.675755

    private Double latitude;
    //89.236011
    private Double longitude;
}
