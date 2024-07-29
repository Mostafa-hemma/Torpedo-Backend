package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.PickUp;
import com.backend.demo.entity.Shipment;

public class PickupResponse {
	
	private String message;
	private List<PickUp> data;
	public PickupResponse(String message) {
		super();
		this.message = message;
	}
	public PickupResponse(String message, List<PickUp> data) {
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
	public List<PickUp> getData() {
		return data;
	}
	public void setData(List<PickUp> data) {
		this.data = data;
	}

}
