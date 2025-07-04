package com.vin.hotel.HotelService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {
	
	@Id
	private String hotelId;
	
	@Column
	private String hotelName;
	
	/*
	 * @Column private Integer rating;
	 */
	
	@Column
	private String about;
	
	@Column
	private String location;

}
