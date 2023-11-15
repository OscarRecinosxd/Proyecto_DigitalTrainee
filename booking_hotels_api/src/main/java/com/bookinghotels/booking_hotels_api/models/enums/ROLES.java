package com.bookinghotels.booking_hotels_api.models.enums;

public enum ROLES {
    ADMIN("admin",1),
    CLIENT("client",2),
    HOTELOWNER("hotel_owner",3);

    private String name;
    private int id;

    ROLES(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
