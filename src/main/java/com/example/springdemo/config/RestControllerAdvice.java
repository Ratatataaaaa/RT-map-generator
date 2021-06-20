package com.example.springdemo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestControllerAdvice {

	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> handleIOException(IOException exc) {
		return ResponseEntity.notFound().build();
	}
}
