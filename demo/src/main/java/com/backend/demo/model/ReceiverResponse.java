package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.Receiver;

public class ReceiverResponse {
	
	private String message;
	private List<Receiver> data;
	public ReceiverResponse(String message) {
		super();
		this.message = message;
	}
	public ReceiverResponse(String message, List<Receiver> data) {
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

	public List<Receiver> getData() {
		return data;
	}
	public void setData(List<Receiver> data) {
		this.data = data;
	}
	
	

}
