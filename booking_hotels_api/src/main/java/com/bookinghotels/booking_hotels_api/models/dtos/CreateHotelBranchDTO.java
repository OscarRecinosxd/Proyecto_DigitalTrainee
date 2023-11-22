package com.bookinghotels.booking_hotels_api.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalTime;

@Data
public class CreateHotelBranchDTO {
    private Long hotelChainId;
    private Long hotelBranchTypeId;
    private String name;
    private String address;
    //13.675755

    @JsonFormat(pattern = "HH:mm")
    private LocalTime checkInTime;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime checkOutTime;

    private Double latitude;
    //89.236011
    private Double longitude;
}
