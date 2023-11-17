package com.bookinghotels.booking_hotels_api.models.dtos.response;

import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import lombok.Data;

import java.util.List;

@Data
public class HotelChainsResponseDTO {
    private Long id;
    private String name;
    private String description;
    private boolean isDeleted;
    private List<HotelBranch> hotelBranches;
}
