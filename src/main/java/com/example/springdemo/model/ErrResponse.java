package com.example.springdemo.model;

public class ErrResponse {
	String message;

	public ErrResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
