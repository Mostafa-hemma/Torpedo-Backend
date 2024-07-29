package com.backend.demo.model;

import java.util.List;

import com.backend.demo.entity.DeliveryAgent;

public class DeliveryAgentResponse {
	
	private String message;
	private List<DeliveryAgent> data;
	public DeliveryAgentResponse(String message) {
		super();
		this.message = message;
	}

	public DeliveryAgentResponse(String message, List<DeliveryAgent> deliveryAgents) {
		super();
		this.message = message;
		this.data = deliveryAgents;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public List<DeliveryAgent> getData() {
		return data;
	}
	public void setData(List<DeliveryAgent> data) {
		this.data = data;
	}
	
	

}
