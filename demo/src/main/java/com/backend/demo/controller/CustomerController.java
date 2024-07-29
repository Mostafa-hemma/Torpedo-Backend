package com.backend.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.backend.demo.entity.Customer;
import com.backend.demo.entity.CustomerAddress;
import com.backend.demo.model.CustomerResponse;
import com.backend.demo.service.CustomerService;

@RestController
public class CustomerController {


	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/customer")
	public ResponseEntity<?> findAll(){
		List<Customer> customers = null;
		try {
			customers= customerService.findAll();
			if(customers.size() !=0) {
			return new ResponseEntity<>(new CustomerResponse("Customer Retrived Successfully", customers),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new CustomerResponse("there is no Customers", customers),HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomerResponse("there is no Customers", customers),HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping(value = "/customer/{id}")
	public ResponseEntity<?> findAll(@PathVariable int id){
		Customer customer=null;
		List<Customer> customers=new ArrayList<Customer>();
		try {
			 customer= customerService.findById(id);
			 customers.add(customer);
			return new ResponseEntity<>(new CustomerResponse("Customer Retrived successfully", customers),HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new CustomerResponse("there is no customer with this id", customers),HttpStatus.NOT_FOUND);

		}
	}
	
	@PostMapping(value="/customer")
	public ResponseEntity<?> addCustmer(@RequestBody Customer myCustomer) {
		Customer customer=null;
		List<Customer> customers=new ArrayList<Customer>();

		try {
			 customer=customerService.addCustomer(myCustomer);
			 customers.add(customer);

			return new ResponseEntity<>(new CustomerResponse("Customer is added successfully", customers),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomerResponse("Couldn't add this Customer", customers),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/customer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer myCustomer){
	Customer customer=null;
	int id=myCustomer.getId();
	List<Customer> customers=new ArrayList<Customer>();
		try {
			 customer=customerService.updateCustomer(id,myCustomer);
			 customers.add(customer);

			return new ResponseEntity<>(new CustomerResponse("Customer is updated Successfully", customers),HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new CustomerResponse("Customer Can Not update this id doesnt exist", customers),HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping(value="/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		try {
			customerService.deleteById(id);
			return new ResponseEntity<>(new CustomerResponse("Customer is Deleted Successfully"),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new CustomerResponse("Can not delete this customer,customer id is not exist"),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/c/reset-password")
	public ResponseEntity<?> updatePassword(@RequestBody Map<String,Object> request){
		int phoneNumber=(int) (request.get("phoneNumber"));
		String newPassword=(String) request.get("password");
		try {
			customerService.updatePassword(phoneNumber, newPassword);
			return new ResponseEntity<>(new CustomerResponse("Password Changed Successfully"),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new CustomerResponse("This Phone Number Is Not Exist"),HttpStatus.NOT_FOUND);

		}
	}
	
	
}
