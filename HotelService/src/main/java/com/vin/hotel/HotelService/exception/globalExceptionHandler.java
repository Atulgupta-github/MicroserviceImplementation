package com.vin.hotel.HotelService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vin.hotel.HotelService.payload.ApiResponse;

@ControllerAdvice
public class globalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExeptionHandle(ResourceNotFoundException exception){
		String message = exception.getMessage();
		ApiResponse response =ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new  ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}

}
