package com.vin.user.service.UserSevice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vin.user.service.UserSevice.Remote.UserRemote;
import com.vin.user.service.UserSevice.entites.User;

import ch.qos.logback.classic.Logger;
/*import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;*/

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRemote userRemote;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = this.userRemote.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
		
		
	}
	 @GetMapping("/{userId}")
	 public ResponseEntity<User> getUser(@PathVariable String userId){
		 User user = this.userRemote.getUser(userId); 
		 return ResponseEntity.ok(user); 
	 }
	/*
	 * @GetMapping("/{userId}")
	 * 
	 * @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod =
	 * "ratingHotelFallback") public ResponseEntity<User> getUser(@PathVariable
	 * String userId){ User user = this.userRemote.getUser(userId); return
	 * ResponseEntity.ok(user); }
	 */
	
	/*
	 * public ResponseEntity<User>ratingHotelFallback(String userId, Exception e){
	 * System.out.println("fall back method executed , sevice is down"+e.getMessage(
	 * )); User user = User.builder().email("ag@gmail.com").username("dummy").
	 * about("this is dummy user because sevice is down").userId("xyz").build();
	 * 
	 * return new ResponseEntity<User>(user, HttpStatus.OK);
	 * 
	 * }
	 */
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = this.userRemote.getAllUser();
		return ResponseEntity.ok(users);
	}
	
	@PutMapping("{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId){
		User updatedUser = this.userRemote.updateUser(userId);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	

}
