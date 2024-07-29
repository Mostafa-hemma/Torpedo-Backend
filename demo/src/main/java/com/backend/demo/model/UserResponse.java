package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.Users;

public class UserResponse {
	
	private String message;
	private List<Users> data;
	
	public UserResponse() {}

	public UserResponse(String message) {
		super();
		this.message = message;
	}

	public UserResponse(List<Users> data) {
		super();
		this.data = data;
	}

	public UserResponse(String message, List<Users> data) {
		super();
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Users> getData() {
		return data;
	}

	public void setData(List<Users> data) {
		this.data = data;
	}
	
	
	

}
