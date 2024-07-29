package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.DeliveryAgent;


public interface DeliveryAgentService {
	
	public List<DeliveryAgent> findAll() throws Exception;
	public DeliveryAgent findById(int id) throws Exception;
	public DeliveryAgent addDeliveryAgent(DeliveryAgent deliveryAgent) throws Exception;
	public DeliveryAgent updateDeliveryAgent(int id,DeliveryAgent deliveryAgent) throws Exception;
	public DeliveryAgent findByPhoneNumber(int phoneNumber) throws Exception;
	public void deleteDeliveryAgent(int id) throws Exception;
	public void updatePassword(int phoneNumber,String newPassword) throws Exception;
}
