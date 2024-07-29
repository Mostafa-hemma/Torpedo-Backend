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
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.dto.PickupDto;
import com.backend.demo.entity.PickUp;
import com.backend.demo.entity.Shipment;
import com.backend.demo.model.PickupResponse;
import com.backend.demo.model.PickupResponseDto;
import com.backend.demo.model.ShipmentResponse;
import com.backend.demo.service.PickupService;

@RestController
public class PickupController {

	@Autowired
	private PickupService pickupService;
	
	@GetMapping(value = "/pickup")
	public ResponseEntity<?> findAll() {
		List<PickUp> pickups = null;
		try {
			pickups = pickupService.findAll();
			if (pickups.size() != 0) {
				return new ResponseEntity<>(new PickupResponse("Pickups Retrived Successfully", pickups), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new PickupResponse("There is no Pickups in DB", pickups), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new PickupResponse("something went wrong", pickups), HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping(value = "/pickup/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		List<PickUp> pickups = new ArrayList<PickUp>();
		PickUp myPickup=new PickUp();
		try {
			myPickup = pickupService.findById(id);
			pickups.add(myPickup);
			if (pickups.size() != 0) {
				return new ResponseEntity<>(new PickupResponse("Pickups Retrived Successfully", pickups), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new PickupResponse("There is no Pickups in DB", pickups), HttpStatus.OK);
			}
		} catch (Exception e) {
			
			return new ResponseEntity<>(new PickupResponse("something went wrong", pickups), HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping(value = "/pickup/customer/{id}")
	public ResponseEntity<?> findByCustomerId(@PathVariable int id) {
		List<PickUp> pickups = null;
		PickupDto pickupDto=null;
		List<PickupDto> customerPickupsDto =new ArrayList<PickupDto>();

		try {
			pickups = pickupService.findAll();
			for(int i=0;i<pickups.size();i++) {
				if(pickups.get(i).getCustomer().getId()==id) {
					 pickupDto=new PickupDto();

					pickupDto.setId(pickups.get(i).getId());
					pickupDto.setNotes(pickups.get(i).getNotes());
					pickupDto.setCustomerId(pickups.get(i).getCustomer().getId());
					if(pickups.get(i).getDeliveryAgent()!=null){
						pickupDto.setAgentId(pickups.get(i).getDeliveryAgent().getId());

					}else {
						pickupDto.setAgentId(0);
					}

					pickupDto.setShipmentsCount(pickups.get(i).getShipmentsCount());
					pickupDto.setPickedShipments(pickups.get(i).getPickedShipments());
					pickupDto.setVehicleType(pickups.get(i).getVehicleType());
					pickupDto.setStatus(pickups.get(i).getStatus());
					pickupDto.setDate(pickups.get(i).getDate());
					customerPickupsDto.add(pickupDto);
				//	PickupDto pickupDto=new PickupDto();

				}
			}
			if (customerPickupsDto.size() != 0) {
				return new ResponseEntity<>(new PickupResponseDto("Pickups Retrived Successfully", customerPickupsDto), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new PickupResponseDto("There is no Pickups in DB", customerPickupsDto), HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new PickupResponseDto("something went wrong", customerPickupsDto), HttpStatus.NOT_FOUND);

		}
		
	}
	
	@GetMapping(value = "/pickup/agent/{id}")
	public ResponseEntity<?> findByAgentId(@PathVariable int id) {
		List<PickUp> pickups = null;
		PickupDto pickupDto=new PickupDto();
		List<PickupDto> customerPickupsDto =new ArrayList<PickupDto>();

		try {
			pickups = pickupService.findAll();
			for(int i=0;i<pickups.size();i++) {
				if(pickups.get(i).getDeliveryAgent().getId()==id) {
					pickupDto.setId(pickups.get(i).getId());
					pickupDto.setNotes(pickups.get(i).getNotes());
					pickupDto.setCustomerId(pickups.get(i).getCustomer().getId());
					pickupDto.setAgentId(pickups.get(i).getDeliveryAgent().getId());
					pickupDto.setShipmentsCount(pickups.get(i).getShipmentsCount());
					pickupDto.setPickedShipments(pickups.get(i).getPickedShipments());
					pickupDto.setVehicleType(pickups.get(i).getVehicleType());
					pickupDto.setStatus(pickups.get(i).getStatus());
					pickupDto.setDate(pickups.get(i).getDate());
					customerPickupsDto.add(pickupDto);
					
				}
			}
			if (customerPickupsDto.size() != 0) {
				return new ResponseEntity<>(new PickupResponseDto("Pickups Retrived Successfully", customerPickupsDto), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new PickupResponseDto("There is no Pickups in DB", customerPickupsDto), HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new PickupResponseDto("something went wrong", customerPickupsDto), HttpStatus.NOT_FOUND);

		}
		
	}
	
	@PostMapping(value = "/pickup")
	public ResponseEntity<?> addItem(@RequestBody PickUp pickup){
		PickUp myPickup= null;
		List<PickUp> pickups =new ArrayList<PickUp>();

		try {
			myPickup=pickupService.addPickup(pickup);
			pickups.add(myPickup);
			return new ResponseEntity<>(new PickupResponse("Pickup is added successfully", pickups), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new PickupResponse("Pickup can not added", pickups), HttpStatus.NOT_FOUND);

		}
	}
	
	@PutMapping(value = "/pickup")
	public ResponseEntity<?> updateItem(@RequestBody PickUp pickup){
		PickUp myPickup= null;
		int id = pickup.getId();
		List<PickUp> pickups =new ArrayList<PickUp>();
		try {
			myPickup=pickupService.updatePickup(id, pickup);
			pickups.add(myPickup);
			return new ResponseEntity<>(new PickupResponse("Pickup is updated Successfully", pickups),HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new PickupResponse("Pickup Can Not update this id doesnt exist", pickups),HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping(value="/pickup/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		try {
			pickupService.deletePickup(id);
			return new ResponseEntity<>(new PickupResponse("Pickup is Deleted Successfully"),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new PickupResponse("Can not delete this Pickup,Pickup id is not exist"),HttpStatus.NOT_FOUND);
		}
	}
}
