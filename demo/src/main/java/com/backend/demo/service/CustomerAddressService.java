package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.CustomerAddress;

import javassist.NotFoundException;

public interface CustomerAddressService {
	
	public List<CustomerAddress> findAll() throws Exception;
	public CustomerAddress findById(int id) throws Exception;
	public CustomerAddress addAddress(CustomerAddress customerAddress);
	public CustomerAddress updateAddress(int id,CustomerAddress customerAddress) throws Exception;
	public void deleteAddress(int id) throws NotFoundException, Exception;
	
}
