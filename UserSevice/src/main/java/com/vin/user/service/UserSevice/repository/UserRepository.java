package com.vin.user.service.UserSevice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.user.service.UserSevice.entites.User;

public interface UserRepository extends JpaRepository<User, String>{

}
