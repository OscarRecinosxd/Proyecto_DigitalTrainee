package com.bookinghotels.booking_hotels_api.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseDTO<T> {
    private List<T> response;
    private String message;

    public ResponseDTO(List<T> response, String message) {
        this.response = response;
        this.message = message;
    }
    public ResponseDTO(T response, String message) {
        this.response = new ArrayList<>();
        this.response.add(response);
        this.message = message;
    }

}
