package com.backend.demo.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.backend.demo.serialization.CustomerSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "shipment")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "order_price")
	private double orderPrice;

	@Column(name = "status")
	private String status;

	@OneToOne
	@JoinColumn(name = "receiver_id", referencedColumnName = "id")
	private Receiver receiver;

	@ManyToOne
	@JoinColumn(name = "customer_id")
    @JsonSerialize(using = CustomerSerializer.class)
	private Customer customer;


	@OneToOne
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Item item;

	@ManyToOne
	@JoinColumn(name = "deliveryagent_id")
	@Nullable
	private DeliveryAgent deliveryAgent;

	@Column(name = "service")
	private String service;

	@Column(name = "shipment_constrains")
	private String shipmentConstrains;

	public Shipment() {
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return item;
	}

	public void setItems(Item item) {
		this.item = item;
	}

	public DeliveryAgent getDeliveryAgent() {
		return deliveryAgent;
	}

	public void setDeliveryAgent(DeliveryAgent deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
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
