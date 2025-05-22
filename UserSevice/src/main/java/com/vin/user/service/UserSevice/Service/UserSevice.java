package com.vin.user.service.UserSevice.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.user.service.UserSevice.Exception.ResourceNotFoundException;
import com.vin.user.service.UserSevice.Remote.UserRemote;
import com.vin.user.service.UserSevice.entites.User;
import com.vin.user.service.UserSevice.repository.UserRepository;

@Service
public class UserSevice implements UserRemote{

	@Autowired
	private UserRepository userRepository;
	
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

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id , user not found"+userId));
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
