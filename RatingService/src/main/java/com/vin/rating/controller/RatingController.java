package com.vin.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vin.rating.entity.Rating;
import com.vin.rating.serviceImp.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	//create Rating
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating ){
		Rating saverating = this.ratingService.createRating(rating);
		return new ResponseEntity<Rating>(saverating, HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> list= this.ratingService.getAllRating();
		return new ResponseEntity<List<Rating>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId){
		List<Rating> rating= this.ratingService.getRatingByUserId(userId);
		return new ResponseEntity<List<Rating>> (rating, HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId){
		List<Rating> rating= this.ratingService.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(rating, HttpStatus.OK);
	}
}
