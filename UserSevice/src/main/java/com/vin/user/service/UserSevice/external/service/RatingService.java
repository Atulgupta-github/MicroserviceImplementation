package com.vin.user.service.UserSevice.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.vin.user.service.UserSevice.entites.Rating;



@FeignClient(name="RATINGSERVICE")
public interface RatingService {
	
	@PostMapping("/ratings")
	public Rating createRating(Rating rating);
	
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating );
	
	@PutMapping("/ratings/{ratingId}")
	public Rating deleteRating(@PathVariable("ratingId") String ratingId );

}
