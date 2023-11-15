package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.entities.Role;

public interface RoleService {
    Role getAdminRole();
    Role getClientRole();
    Role getHotelOwnerRole();
}
