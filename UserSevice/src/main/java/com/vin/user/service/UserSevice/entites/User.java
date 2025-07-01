package com.vin.user.service.UserSevice.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="micro_users")
@Builder
public class User {
	
	@Id
	@Column(name="ID")
	private String userId;
	
	@Column(name="NAME" ,length = 25)
	private String username;
	
	@Column(name="DOB")
	private String DOB;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
	


}
