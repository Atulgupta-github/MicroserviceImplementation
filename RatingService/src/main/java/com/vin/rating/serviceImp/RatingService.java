package com.vin.rating.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.rating.entity.Rating;
import com.vin.rating.repository.RatingRepository;
import com.vin.rating.service.RatingRemote;


@Service
public class RatingService implements RatingRemote {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	
	@Override
	public Rating createRating(Rating rating) {
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
		
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}
	
	

}
