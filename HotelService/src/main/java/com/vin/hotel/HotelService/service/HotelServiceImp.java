package com.vin.hotel.HotelService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.hotel.HotelService.Entity.Hotel;
import com.vin.hotel.HotelService.exception.ResourceNotFoundException;
import com.vin.hotel.HotelService.payload.ApiResponse;
import com.vin.hotel.HotelService.remote.HotelRemote;
import com.vin.hotel.HotelService.repository.HotelRepository;
@Service
public class HotelServiceImp implements HotelRemote {
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setHotelId(id);
		Hotel savedHotel = this.hotelRepository.save(hotel);
		return savedHotel;
	}

	@Override
	public List<Hotel> getAllHotel() {
		List<Hotel> list =  this.hotelRepository.findAll();
		return list;
	}

	@Override
	public Hotel fetchHotel(String id) {
		return this.hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel is not found for this id"+id));
		
	}

	@Override
	public Hotel UpdateHotel(String id) {
		Hotel hotel =this.hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel is not found for this id"+id));
		return hotel;
	}

	@Override
	public ApiResponse deleteHote(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
