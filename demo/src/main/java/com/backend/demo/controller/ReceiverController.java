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

import com.backend.demo.entity.Receiver;
import com.backend.demo.model.ReceiverResponse;
import com.backend.demo.service.ReceiverService;

@RestController
public class ReceiverController {
	
	@Autowired
	private ReceiverService receiverService;
	
	@GetMapping(value = "/receiver")
	public ResponseEntity<?> findAll() {
		List<Receiver> receivers = null;
		try {
			receivers = receiverService.findAll();
			if (receivers.size() != 0) {
				return new ResponseEntity<>(new ReceiverResponse("Receivers Retrived Successfully", receivers), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ReceiverResponse("There is no Receivers in DB", receivers), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new ReceiverResponse("something went wrong", receivers), HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping(value = "/receiver/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Receiver receiver= null;
		List<Receiver> receivers =new ArrayList<Receiver>();
		try {
			receiver = receiverService.findById(id);
			receivers.add(receiver);
			return new ResponseEntity<>(new ReceiverResponse("Receiver Retrived Successfully", receivers), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ReceiverResponse("There is no Receiver with this id", receivers),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/receiver")
	public ResponseEntity<?> addItem(@RequestBody Receiver receiver){
		Receiver myReceiver=null;
		List<Receiver> receivers =new ArrayList<Receiver>();

		try {
			myReceiver=receiverService.addReceiver(receiver);
			receivers.add(myReceiver);
			return new ResponseEntity<>(new ReceiverResponse("Receiver is added successfully", receivers), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(new ReceiverResponse("Receiver can not added", receivers), HttpStatus.NOT_FOUND);

		}
	}
	
	@PutMapping(value = "/receiver")
	public ResponseEntity<?> updateItem(@RequestBody Receiver receiver){
		Receiver myReceiver=null;
	int id=receiver.getId();
	List<Receiver> receivers =new ArrayList<Receiver>();
		try {
			myReceiver=receiverService.updateReceiver(id,receiver);
			receivers.add(myReceiver);
			return new ResponseEntity<>(new ReceiverResponse("Receiver is updated Successfully", receivers),HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ReceiverResponse("Receiver Can Not update this id doesnt exist", receivers),HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping(value="/receiver/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		try {
			receiverService.deleteReceiver(id);
			return new ResponseEntity<>(new ReceiverResponse("Receiver is Deleted Successfully"),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ReceiverResponse("Can not delete this Receiver,Receiver id is not exist"),HttpStatus.NOT_FOUND);
		}
	}

}
