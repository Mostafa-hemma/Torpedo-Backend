package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.Shipment;

public class ShipmentResponseDto {
	private String message;
	private List<ShipmentDto> data;
	public ShipmentResponseDto(String message) {
		super();
		this.message = message;
	}
	public ShipmentResponseDto(String message, List<ShipmentDto> data) {
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
	public List<ShipmentDto> getData() {
		return data;
	}
	public void setData(List<ShipmentDto> data) {
		this.data = data;
	}
}
