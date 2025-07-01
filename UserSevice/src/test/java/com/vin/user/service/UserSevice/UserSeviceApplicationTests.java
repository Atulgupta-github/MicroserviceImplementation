package com.vin.user.service.UserSevice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vin.user.service.UserSevice.entites.Rating;
import com.vin.user.service.UserSevice.external.service.RatingService;

@SpringBootTest
class UserSeviceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
	@Test
	void createRating() {
		Rating saverating = Rating.builder().rating(3).userId("abc").hotelId("xxxx").feedBack("good ").build();
		
		Rating savedRating =ratingService.createRating(saverating);
		
		System.out.println(savedRating);
	}

}
