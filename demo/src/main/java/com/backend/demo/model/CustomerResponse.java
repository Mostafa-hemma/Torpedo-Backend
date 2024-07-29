package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.Customer;
import com.backend.demo.entity.CustomerAddress;
import com.backend.demo.entity.Shipment;

public class CustomerResponse {
	private String message;
	private List<Customer> data;
	
	public CustomerResponse(String message) {
		super();
		this.message = message;
	}



	public CustomerResponse(String message, List<Customer> data) {
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



	public List<Customer> getData() {
		return data;
	}

	public void setData(List<Customer> data) {
		this.data = data;
	}
	
	
	
}
