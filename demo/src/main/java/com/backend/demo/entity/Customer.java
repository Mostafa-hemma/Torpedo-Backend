package com.backend.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "customer")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="password")
	@JsonIgnore

	private String password;
	
	@Column(name="phoneNumber")
	private int phoneNumber;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<CustomerAddress> addresses;
	
	@OneToMany(mappedBy = "customer" , cascade =CascadeType.REFRESH)
	@JsonIgnore
	private List<Shipment> shipments;
	
	@OneToMany(mappedBy = "customer" , cascade =CascadeType.REFRESH)
	@JsonIgnore
	private List<PickUp> pickups;
	
	@Column
	private String role;
	
	@Column
	private double balance;

	public Customer() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<CustomerAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<CustomerAddress> addresses) {
		this.addresses = addresses;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<PickUp> getPickups() {
		return pickups;
	}

	public void setPickups(List<PickUp> pickups) {
		this.pickups = pickups;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
	
}
