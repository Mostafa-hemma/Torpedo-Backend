package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.Item;
import com.backend.demo.entity.Shipment;

public interface ShipmentService {
	
	public List<Shipment> findAll() throws Exception;
	public Shipment findById(int id) throws Exception;
	public Shipment addShipment(Shipment shipment) throws Exception;
	public Shipment updateShipment(int id,Shipment shipment) throws Exception;
	public void deleteShipment(int id) throws Exception;

}
