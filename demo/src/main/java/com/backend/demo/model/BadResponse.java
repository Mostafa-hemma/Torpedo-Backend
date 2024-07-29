package com.backend.demo.model;

public class BadResponse {
	
	private String message;
	private int httpStatus;
	
	public BadResponse() {
	}

	public BadResponse(String message, int httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	

}
