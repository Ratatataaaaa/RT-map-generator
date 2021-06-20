package com.example.springdemo.config;

import com.example.springdemo.exception.StudentIOException;
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

	@ExceptionHandler(StudentIOException.class)
	public ResponseEntity<?> handleRTException(StudentIOException exc) {
		return ResponseEntity.notFound().build();
	}

}
