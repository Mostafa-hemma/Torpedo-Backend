package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.PickUp;
import com.backend.demo.entity.Shipment;

public interface PickupService {

	public List<PickUp> findAll() throws Exception;
	public PickUp findById(int id) throws Exception;
	public PickUp addPickup(PickUp pickup) throws Exception;
	public PickUp updatePickup(int id,PickUp pickup) throws Exception;
	public void deletePickup(int id) throws Exception;
}
