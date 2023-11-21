package com.bookinghotels.booking_hotels_api.models.dtos.response;

import com.bookinghotels.booking_hotels_api.models.entities.Booking;
import com.bookinghotels.booking_hotels_api.models.entities.Role;
import lombok.Data;
import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean isDeleted;
    private Role userRole;
    private List<Booking> bookings;
}
