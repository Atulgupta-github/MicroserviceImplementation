 package com.vin.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.rating.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{
	
	//customFindmethod
	
	List<Rating> findByUserId(String userId);
	
	
	List<Rating> findByHotelId(String hotelId);

}
