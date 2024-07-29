package com.backend.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.entity.DeliveryAgent;
import com.backend.demo.model.DeliveryAgentResponse;
import com.backend.demo.service.DeliveryAgentService;

@RestController
public class DeliveryAgentController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DeliveryAgentService deliveryAgentService;
	
	@GetMapping(value = "/agent")
	public ResponseEntity<?> findAll(){
		List<DeliveryAgent> agents = null;
		try {
			agents= deliveryAgentService.findAll();
			if(agents.size() !=0) {
			return new ResponseEntity<>(new DeliveryAgentResponse("Delivery Agents Retrived Successfully", agents),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new DeliveryAgentResponse("there is no Delivery Agents", agents),HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<>(new DeliveryAgentResponse("there is no Delivery Agents", agents),HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping(value = "/agent/{id}")
	public ResponseEntity<?> findAll(@PathVariable int id){
		DeliveryAgent agent=null;
		List<DeliveryAgent> agents =new ArrayList<DeliveryAgent>();
		try {
			agent= deliveryAgentService.findById(id);
			agents.add(agent);
			return new ResponseEntity<>(new DeliveryAgentResponse("Delivery Agent Retrived successfully", agents),HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<>(new DeliveryAgentResponse("there is no Delivery Agent with this id", agents),HttpStatus.NOT_FOUND);

		}
	}
	
	@PostMapping(value="/agent")
	public ResponseEntity<?> addAgent(@RequestBody DeliveryAgent myAgent) {
	
		DeliveryAgent agent=null;
		List<DeliveryAgent> agents =new ArrayList<DeliveryAgent>();

		try {
			agent=deliveryAgentService.addDeliveryAgent(myAgent);
			agents.add(agent);

			return new ResponseEntity<>(new DeliveryAgentResponse("Delivery Agent is added successfully", agents),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<>(new DeliveryAgentResponse("Couldn't add this Delivery Agent", agents),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/agent")
	public ResponseEntity<?> updateAgent(@RequestBody DeliveryAgent myDeliveryAgent){
	DeliveryAgent deliveryAgent=null;
	int id=myDeliveryAgent.getId();
	List<DeliveryAgent> agents =new ArrayList<DeliveryAgent>();
		try {
			deliveryAgent=deliveryAgentService.updateDeliveryAgent(id,myDeliveryAgent);
			agents.add(deliveryAgent);

			return new ResponseEntity<>(new DeliveryAgentResponse("Delivery Agent is updated Successfully", agents),HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<>(new DeliveryAgentResponse("Delivery Agent Can Not update this id doesnt exist", agents),HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping(value="/agent/{id}")
	public ResponseEntity<?> deleteAgent(@PathVariable int id) {
		try {
			deliveryAgentService.deleteDeliveryAgent(id);
			return new ResponseEntity<>(new DeliveryAgentResponse("Delivery Agent is Deleted Successfully"),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new DeliveryAgentResponse("Can not delete this Delivery Agent,Delivery Agent id is not exist"),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "a/reset-password")
	public ResponseEntity<?> updatePassword(@RequestBody Map<String, Object> request){
		int phoneNumber=(int) request.get("phoneNumber");
		String newPassword=(String) request.get("password");
		try {
			deliveryAgentService.updatePassword(phoneNumber, newPassword);
			return new ResponseEntity<>(new DeliveryAgentResponse("Password is updated Successfully"),HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new DeliveryAgentResponse("This Agent is Not Exist please enter the right phone number"),HttpStatus.NOT_FOUND);
		}
	}
	

}
