package com.quiz.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		 String message= ex.getMessage();
		 ApiResponse response = new ApiResponse(message);
		 return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}

}
