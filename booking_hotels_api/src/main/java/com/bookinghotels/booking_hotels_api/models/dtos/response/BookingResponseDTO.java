package com.bookinghotels.booking_hotels_api.models.dtos.response;

import com.bookinghotels.booking_hotels_api.models.entities.Invoice;
import com.bookinghotels.booking_hotels_api.models.entities.Room;
import com.bookinghotels.booking_hotels_api.models.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingResponseDTO {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;

    private boolean isPaid;
    private boolean isDeleted;
    private User user;
    private Invoice invoice;
    private List<Room> rooms;
}
