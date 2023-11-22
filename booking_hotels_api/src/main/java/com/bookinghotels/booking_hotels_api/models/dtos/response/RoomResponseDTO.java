package com.bookinghotels.booking_hotels_api.models.dtos.response;

import com.bookinghotels.booking_hotels_api.models.entities.Booking;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.models.entities.RoomType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class RoomResponseDTO {
    private Long id;
    private String number;
    private int capacity;
    private float price;
    private boolean isDeleted;
    private RoomType roomType;
    private HotelBranch hotelBranch;
    private List<Booking> bookings;
}
