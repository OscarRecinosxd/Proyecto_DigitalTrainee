package com.bookinghotels.booking_hotels_api.repositories;

import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBranchRepository extends JpaRepository<HotelBranch, Long> {
}
