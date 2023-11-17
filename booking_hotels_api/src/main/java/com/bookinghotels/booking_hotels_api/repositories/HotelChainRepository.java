package com.bookinghotels.booking_hotels_api.repositories;

import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelChainRepository extends JpaRepository<HotelChain,Long> {
    @Query(value = "insert into your_table (geog) values (SRID=4326;POINT(longitude latitude))",nativeQuery = true)
    void insertGeo(Double lng, Double lat);

}
