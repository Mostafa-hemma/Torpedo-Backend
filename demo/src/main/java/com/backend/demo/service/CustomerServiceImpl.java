package com.backend.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.CustomerDao;
import com.backend.demo.entity.Customer;
import com.backend.demo.entity.CustomerAddress;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Customer> findAll() throws Exception{
		return customerDao.findAll();
	}

	@Override
	public Customer findById(int id)throws Exception {
		//Optional<Customer> result = customerDao.findById(id);
		Customer customer=customerDao.findById(id).orElseThrow(()-> new Exception());
//		if(result.isPresent()) {
//			customer=result.get();
//		}
		return customer;
	}

	@Override
	public Customer addCustomer(Customer myCustomer) throws Exception{
		myCustomer.setId(0);
		myCustomer.setRole("ROLE_CUSTOMER");
		myCustomer.setPassword(bCryptPasswordEncoder.encode(myCustomer.getPassword()));
		Customer customer=customerDao.save(myCustomer);
		return customer;
	}

	@Override
	public Customer updateCustomer(int id ,Customer myCustomer) throws Exception{
		if(findById(id)==null) {
			throw new Exception();
		}
		myCustomer.setRole("ROLE_CUSTOMER");

		Customer customer=customerDao.save(myCustomer);
		return customer;
	}

	@Override
	public void deleteById(int id) throws Exception{
		customerDao.deleteById(id);

	}

	@Override
	public void updatePassword(int phoneNumber, String newPassword) throws Exception {
		
		Customer myCustomer=customerDao.findByPhoneNumber(phoneNumber).orElse(null);
		if(myCustomer==null) {
			throw new Exception();
		}
		myCustomer.setPassword(bCryptPasswordEncoder.encode(newPassword));
		customerDao.save(myCustomer);
		
	}

	@Override
	public Customer findByPhoneNumber(int phoneNumber) throws Exception {
		Customer customer=customerDao.findByPhoneNumber(phoneNumber).orElseThrow(()-> new Exception());
		return customer;
	}

}
