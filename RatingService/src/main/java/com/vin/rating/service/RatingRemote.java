package com.vin.rating.service;

import java.util.List;

import com.vin.rating.entity.Rating;

public interface RatingRemote {

	//create Rating
	
	public Rating createRating(Rating rating);
	
	
	//getAllRating
	
	public List<Rating> getAllRating();
	
	
	public List<Rating> getRatingByUserId(String userId);
	
	public List<Rating> getRatingByHotelId(String hotelId);
	
	
}
