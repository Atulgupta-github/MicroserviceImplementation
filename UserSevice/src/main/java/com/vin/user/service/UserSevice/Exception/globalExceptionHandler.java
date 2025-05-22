package com.vin.user.service.UserSevice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vin.user.service.UserSevice.payload.ApiResponse;

@ControllerAdvice
public class globalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> heandlerResourceNotFoundException(ResourceNotFoundException exception){
		String message = exception.getMessage();
		ApiResponse response = ApiResponse.builder().meassage(message).success(true).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
		
	}

}
