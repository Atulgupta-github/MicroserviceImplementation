package com.vin.user.service.UserSevice.Service;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vin.user.service.UserSevice.Exception.ResourceNotFoundException;
import com.vin.user.service.UserSevice.Remote.UserRemote;
import com.vin.user.service.UserSevice.entites.Hotel;
import com.vin.user.service.UserSevice.entites.Rating;
import com.vin.user.service.UserSevice.entites.User;
import com.vin.user.service.UserSevice.external.service.HotelService;
import com.vin.user.service.UserSevice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserSevice implements UserRemote{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private org.slf4j.Logger logger =  LoggerFactory.getLogger(UserSevice.class);
	
	@Override
	public User saveUser(User user) {
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		User savedUser = this.userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUser() {
		List<User> listUser = this.userRepository.findAll();
		return listUser;
	}

	/*@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user =userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id , user not found"+userId));
		
		
		//fatch Rating using rest template
		//http://localhost:8083/ratings/users/437a1ac4-e933-4434-8448-676157009143
		
		Rating[] ratingForUser= restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		
		List<Rating> ratingList=Arrays.stream(ratingForUser).toList();
		
		
		
		user.setRatings(ratingList);
		
	
		
		
		ratingList.stream().map(rating->{
			ResponseEntity<Hotel> ent=restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+rating.getHotelId(), Hotel.class);
			Hotel hotel =ent.getBody(); 
			logger.info("status code is {}",ent.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		 
		
		
		logger.info("{}",ratingForUser.toString());
		return user;
	}*/
	
	//Using feign client
	public User getUser(String userId) {
		User user =userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id , user not found"+userId));
		//using rest template
		Rating[] ratingForUser= restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		List<Rating> ratingList=Arrays.stream(ratingForUser).toList();
		user.setRatings(ratingList);
		
		//using feign client
		ratingList.stream().map(rating->{
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		
		
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private Object ResourceNotFoundException(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

}
