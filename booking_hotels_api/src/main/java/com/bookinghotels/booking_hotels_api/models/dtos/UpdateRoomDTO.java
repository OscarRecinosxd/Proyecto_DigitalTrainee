package com.bookinghotels.booking_hotels_api.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalTime;

@Data
public class UpdateRoomDTO {
    private Long roomTypeId;
    @Schema(type = "String", pattern = "HH:mm")
    private LocalTime CheckIntTime;
    @Schema(type = "String", pattern = "HH:mm")
    private LocalTime CheckOutTime;
    private int capacity;
    private float price;
}
