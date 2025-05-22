package com.vin.hotel.HotelService.remote;

import java.util.List;

import com.vin.hotel.HotelService.Entity.Hotel;
import com.vin.hotel.HotelService.payload.ApiResponse;

public interface HotelRemote {
	
	public Hotel saveHotel(Hotel hotel);
	
	public List<Hotel> getAllHotel();
	
	public Hotel fetchHotel(String id);
	
	public Hotel UpdateHotel(String id);
	
	public ApiResponse deleteHote(String id);

}
