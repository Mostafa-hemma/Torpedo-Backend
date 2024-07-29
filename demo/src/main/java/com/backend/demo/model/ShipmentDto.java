package com.backend.demo.model;

import com.backend.demo.entity.Item;
import com.backend.demo.entity.Receiver;



public class ShipmentDto {
	
	private int id;
	private double orderPrice;
	private String status;
	private Receiver receiver;
	private int customerId;
	private Item item;
	private int deliveryAgentId;
	private String service;
	private String shipmentConstrains;
	
	public ShipmentDto() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getDeliveryAgentId() {
		return deliveryAgentId;
	}

	public void setDeliveryAgentId(int deliveryAgentId) {
		this.deliveryAgentId = deliveryAgentId;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getShipmentConstrains() {
		return shipmentConstrains;
	}

	public void setShipmentConstrains(String shipmentConstrains) {
		this.shipmentConstrains = shipmentConstrains;
	}
	
	
	

}
