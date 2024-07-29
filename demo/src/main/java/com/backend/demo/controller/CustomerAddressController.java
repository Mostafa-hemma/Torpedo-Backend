package com.backend.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.dao.CustomerAddressDao;
import com.backend.demo.entity.CustomerAddress;
import com.backend.demo.model.CustomerAddressResponse;
import com.backend.demo.service.CustomerAddressService;

import javassist.NotFoundException;

@RestController
public class CustomerAddressController {
	
	@Autowired
	private CustomerAddressService customerAddressService;
	
	@GetMapping(value = "/customeraddress")
	public  ResponseEntity<?> findAll(){
		List<CustomerAddress> addresses;
		try {
			addresses= customerAddressService.findAll();
			if(addresses.size()!=0) {
				return new ResponseEntity<>(new CustomerAddressResponse("Addresses Retrived Successfully",addresses),HttpStatus.OK);

			}else {
			return new ResponseEntity<>(new CustomerAddressResponse("There is no addresses in DB",addresses),HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return  ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value = "/customeraddress/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		CustomerAddress myCustomerAddress=null;
		List<CustomerAddress> addresses =new  ArrayList<CustomerAddress>();
		try {
			 myCustomerAddress= customerAddressService.findById(id);
			 addresses.add(myCustomerAddress);
			return new ResponseEntity<>(new CustomerAddressResponse("the Address Retreved Successfully",addresses),HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new CustomerAddressResponse("this address id is not found : "+id,addresses),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/customeraddress")
	public ResponseEntity<?> addCustmerAddress(@RequestBody CustomerAddress myCustomerAddress) {
		List<CustomerAddress> addresses = new  ArrayList<CustomerAddress>();
		myCustomerAddress.setId(0);
		CustomerAddress myAddress=customerAddressService.addAddress(myCustomerAddress);
		addresses.add(myAddress);
		return new ResponseEntity<>(new CustomerAddressResponse("this address is added Successfully",addresses),HttpStatus.OK);

	}
	
	
	@PutMapping(value = "/customeraddress")
	public ResponseEntity<?> updateAddress(@RequestBody CustomerAddress myCustomerAddress)
	{	 int id=myCustomerAddress.getId();
		 List<CustomerAddress> addresses = new  ArrayList<CustomerAddress>();

		 try {
			CustomerAddress customerAddress = customerAddressService.updateAddress(id,myCustomerAddress);
			addresses.add(customerAddress);
			return new ResponseEntity<>(new CustomerAddressResponse("the Address Updated Successfully",addresses),HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new CustomerAddressResponse("the Address couldnt update"),HttpStatus.NOT_FOUND);
		}
		
	}
	@DeleteMapping(value="/customeraddress/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable int id) {
		try {
			customerAddressService.deleteAddress(id);
			return new ResponseEntity<>(new CustomerAddressResponse("the Address deleted Successfully"),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomerAddressResponse("There is no address with this id "),HttpStatus.NOT_FOUND);

			//e.printStackTrace();
		}
	}
}
