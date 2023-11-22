package com.bookinghotels.booking_hotels_api.models.dtos.response;

import com.bookinghotels.booking_hotels_api.models.entities.HotelBranchType;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalTime;

@Data
public class HotelBranchResponseDTO {
    private HotelChain hotelChain;
    private HotelBranchType hotelBranchType;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime checkInTime;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime checkOutTime;

    private String name;
    private String address;
    private boolean isDeleted;
}
