package com.vin.rating.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vin.rating.payload.ApiResponse;



@RestControllerAdvice
public class globalExceptionHandler {
	
	@Autowired
	private ApiResponse apiResponse;
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> heandlerResourceNotFoundException (ResourceNotFoundException exception){
		String msg = exception.getMessage();
		apiResponse.setMeassage(msg);
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		apiResponse.setSuccess(false);
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
		
	}

}
