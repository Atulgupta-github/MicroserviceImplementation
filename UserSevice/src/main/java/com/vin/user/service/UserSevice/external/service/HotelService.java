package com.vin.user.service.UserSevice.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vin.user.service.UserSevice.entites.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {
	
	@GetMapping("/hotel/{hotelId}")
	public Hotel getHotel(@PathVariable("hotelId") String hotelId);

}
