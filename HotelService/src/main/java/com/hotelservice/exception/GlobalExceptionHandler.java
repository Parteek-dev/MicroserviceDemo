package com.hotelservice.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<HashMap<String, Object>> ResourceNotFoundHandler(ResourceNotFoundException rException){
		
		HashMap<String, Object> hashMap = new HashMap<>(3);
		hashMap.put("message", rException.getMessage());
		hashMap.put("success", false);
		hashMap.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
	}
}
