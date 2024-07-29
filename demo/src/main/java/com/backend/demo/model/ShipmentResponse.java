package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.Shipment;

public class ShipmentResponse {

	private String message;
	private List<Shipment> data;
	public ShipmentResponse(String message) {
		super();
		this.message = message;
	}
	public ShipmentResponse(String message, List<Shipment> data) {
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
	public List<Shipment> getData() {
		return data;
	}
	public void setData(List<Shipment> data) {
		this.data = data;
	}
	
	
	
}
