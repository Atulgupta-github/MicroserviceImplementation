package com.vin.user.service.UserSevice.Remote;

import java.util.List;

import com.vin.user.service.UserSevice.entites.User;

public interface UserRemote {
	
	public User saveUser(User user);
	
	public List<User> getAllUser();
	
	public User getUser(String userId);
	
	
	public User updateUser(String userId);
	
	public void deleteUser(String userId);
	
	
	
	

}
