package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.CustomerAddress;

public class CustomerAddressResponse {
	private String message;
	private List<CustomerAddress> data;
	
	
	public CustomerAddressResponse(String message) {
		super();
		this.message = message;
	}


	public CustomerAddressResponse(String message, List<CustomerAddress> data) {
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




	public List<CustomerAddress> getData() {
		return data;
	}


	public void setData(List<CustomerAddress> data) {
		this.data = data;
	}

	

	

}
