package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.Item;

public class ItemResponse {
	
	private String message;
	private List<Item> data;
	public ItemResponse(String message) {
		super();
		this.message = message;
	}
	public ItemResponse(String message, List<Item> data) {
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

	public List<Item> getData() {
		return data;
	}
	public void setData(List<Item> data) {
		this.data = data;
	}
	
	

}
