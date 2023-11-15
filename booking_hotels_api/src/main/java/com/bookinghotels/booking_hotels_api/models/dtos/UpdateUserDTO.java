package com.bookinghotels.booking_hotels_api.models.dtos;

import lombok.Data;

@Data
public class UpdateUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int role;
}
