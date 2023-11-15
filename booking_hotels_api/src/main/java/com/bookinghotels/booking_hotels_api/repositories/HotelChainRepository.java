package com.bookinghotels.booking_hotels_api.repositories;

import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelChainRepository extends JpaRepository<HotelChain,Long> {
}
