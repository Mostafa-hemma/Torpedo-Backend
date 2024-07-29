package com.backend.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.backend.demo.serialization.CustomerSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="pickup")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class PickUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "shipmentsCount")
	private int shipmentsCount;
	
	@Column(name="pickedShipments")
	private int pickedShipments;
	
	@Column(name="vehicleType")
	private String vehicleType;
	
	@Column(name="status")
	private String status;
	
	@Column(name="notes")
	private String notes;
	

	
	@ManyToOne
	@JoinColumn(name="customer_id")
    @JsonSerialize(using = CustomerSerializer.class)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="deliveryagent_id")
	private DeliveryAgent deliveryAgent;
	
	
	@Column
	private LocalDate date;
	
	public PickUp() {
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public DeliveryAgent getDeliveryAgent() {
		return deliveryAgent;
	}

	public void setDeliveryAgent(DeliveryAgent deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}
	
	
	
}
