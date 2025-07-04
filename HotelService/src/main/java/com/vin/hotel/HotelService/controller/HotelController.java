package com.vin.hotel.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vin.hotel.HotelService.Entity.Hotel;
import com.vin.hotel.HotelService.remote.HotelRemote;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelRemote hotelRemote;
	
	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel savedHotel = this.hotelRemote.saveHotel(hotel);
		return new ResponseEntity<Hotel>(savedHotel, HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> fetchAllHotels(){
		List<Hotel> list = this.hotelRemote.getAllHotel();
		return new ResponseEntity<List<Hotel>>(list, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> fetchHotel(@PathVariable String id){
		Hotel hotel = this.hotelRemote.fetchHotel(id);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
		
	}

}
