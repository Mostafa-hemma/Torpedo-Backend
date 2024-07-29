package com.backend.demo.dto;

import java.time.LocalDate;

public class PickupDto {
	
	private int id;
	private int shipmentsCount;
	private int pickedShipments;
	private String vehicleType;
	private String status;
	private String notes;
	private int customerId;
	private int agentId;
	private LocalDate date;
	public PickupDto(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShipmentsCount() {
		return shipmentsCount;
	}

	public void setShipmentsCount(int shipmentsCount) {
		this.shipmentsCount = shipmentsCount;
	}

	public int getPickedShipments() {
		return pickedShipments;
	}

	public void setPickedShipments(int pickedShipments) {
		this.pickedShipments = pickedShipments;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
