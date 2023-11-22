package com.bookinghotels.booking_hotels_api.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalTime;

@Data
public class CreateRoomDTO {
    private Long hotelBranchId;
    private Long roomTypeId;
    private String roomIdentifier;
    private int capacity;
    private float price;

}
