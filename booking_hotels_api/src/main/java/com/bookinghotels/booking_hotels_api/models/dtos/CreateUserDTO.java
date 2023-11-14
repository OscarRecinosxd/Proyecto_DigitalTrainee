package com.bookinghotels.booking_hotels_api.models.dtos;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
}
