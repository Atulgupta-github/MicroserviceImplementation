package com.vin.user.service.UserSevice.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

	private String ratingId;
	
	
	private String userId;
	
	private String hotelId;
	
	private int rating;
	
	private String feedBack;
	
	private Hotel hotel;

}
