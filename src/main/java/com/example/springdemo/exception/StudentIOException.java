package com.example.springdemo.exception;

public class StudentIOException extends RuntimeException {

	public StudentIOException() {
	}

	public StudentIOException(String message) {
		super(message);
	}

	public StudentIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentIOException(Throwable cause) {
		super(cause);
	}

	public StudentIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
