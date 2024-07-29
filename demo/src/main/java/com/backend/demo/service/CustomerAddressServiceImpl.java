package com.backend.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.CustomerAddressDao;
import com.backend.demo.entity.CustomerAddress;

import javassist.NotFoundException;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
	
	@Autowired
	private CustomerAddressDao customerAddressDao;

	@Override
	public List<CustomerAddress> findAll() throws Exception{
		return customerAddressDao.findAll();
	}

	@Override
	public CustomerAddress findById(int id) throws Exception {
		
		//Optional<CustomerAddress> result = customerAddressDao.findById(id);
		CustomerAddress customerAddress=customerAddressDao.findById(id)
				.orElseThrow(() -> new Exception());
		//if(result.isPresent()) {
			//customerAddress=result.get();
	//	}
		return customerAddress;
	}

	@Override
	public CustomerAddress addAddress(CustomerAddress customerAddress) {
		CustomerAddress myAddress=customerAddressDao.save(customerAddress);
		return myAddress;
	}

	@Override
	public CustomerAddress updateAddress(int id,CustomerAddress customerAddress) throws Exception {
		if(findById(id)==null) {
			throw new Exception();
		}
		
		CustomerAddress myCustomerAddress=null;
		myCustomerAddress=customerAddressDao.save(customerAddress);
		return myCustomerAddress;
	}

	@Override
	public void deleteAddress(int id) throws Exception {
//		if(customerAddressDao.findById(id)==null) {
//			throw new NotFoundException("there is no Address with this id : "+id);
//		}
		customerAddressDao.deleteById(id);
	}

}
