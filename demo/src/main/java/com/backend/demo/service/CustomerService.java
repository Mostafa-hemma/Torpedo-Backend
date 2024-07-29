package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll() throws Exception;
	public Customer findById(int id) throws Exception;
	public Customer findByPhoneNumber(int phoneNumber) throws Exception;
	public Customer addCustomer(Customer myCustomer) throws Exception;
	public Customer updateCustomer(int id,Customer myCustomer) throws Exception;
	public void deleteById(int id) throws Exception;
	public void updatePassword(int phoneNumber,String newPassword) throws Exception;

}
