package com.madcoder.madwatch.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<MovieErrorResponse> handleNotFound(MovieNotFound notFound) {
		MovieErrorResponse movieErrorResponse = new MovieErrorResponse();
		
		movieErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		movieErrorResponse.setMessage(notFound.getMessage());
		movieErrorResponse.setTimestands(System.currentTimeMillis());
		
		return new ResponseEntity<MovieErrorResponse>(movieErrorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<MovieErrorResponse> handleNotFound1(NoSuchElementException notFound) {
		MovieErrorResponse movieErrorResponse = new MovieErrorResponse();
		
		movieErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		movieErrorResponse.setMessage(notFound.getMessage());
		movieErrorResponse.setTimestands(System.currentTimeMillis());
		
		return new ResponseEntity<MovieErrorResponse>(movieErrorResponse, HttpStatus.NOT_FOUND);
		
	}
}
