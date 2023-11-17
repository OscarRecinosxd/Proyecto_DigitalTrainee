package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.entities.RoomType;

public interface RoomTypeService {
    RoomType findById(Long id);
}
