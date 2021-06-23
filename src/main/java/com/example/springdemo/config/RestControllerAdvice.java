package com.example.springdemo.config;

import com.example.springdemo.model.ErrResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestControllerAdvice {
	private static final Logger log = LoggerFactory.getLogger(RestControllerAdvice.class);

	@ExceptionHandler(IOException.class)
	public ResponseEntity<ErrResponse> handleIOException(IOException ex) {
		log.error("User: {}", SecurityContextHolder.getContext().getAuthentication().getName(), ex);
		return new ResponseEntity<>(
				new ErrResponse(ex.getMessage()),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
		log.error("User: {}", SecurityContextHolder.getContext().getAuthentication().getName(), ex);
		return new ResponseEntity<>(
				new ErrResponse(ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrResponse> handleException(Exception ex) {
		log.error("User: {}", SecurityContextHolder.getContext().getAuthentication().getName(), ex);
		return new ResponseEntity<>(
				new ErrResponse("Неожиданное завершение"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
