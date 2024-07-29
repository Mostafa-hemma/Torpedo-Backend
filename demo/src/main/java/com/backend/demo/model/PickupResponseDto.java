package com.backend.demo.model;

import java.util.List;

import com.backend.demo.dto.PickupDto;
import com.backend.demo.entity.PickUp;

public class PickupResponseDto {
	private String message;
	private List<PickupDto> data;
	public PickupResponseDto(String message) {
		super();
		this.message = message;
	}
	public PickupResponseDto(String message, List<PickupDto> data) {
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
	public List<PickupDto> getData() {
		return data;
	}
	public void setData(List<PickupDto> data) {
		this.data = data;
	}


}
