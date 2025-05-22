package com.vin.hotel.HotelService.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.hotel.HotelService.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
