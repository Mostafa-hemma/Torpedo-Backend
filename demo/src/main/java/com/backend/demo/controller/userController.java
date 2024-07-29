package com.backend.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

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

import com.backend.demo.entity.Shipment;
import com.backend.demo.entity.Users;
import com.backend.demo.model.DeliveryAgentResponse;
import com.backend.demo.model.ShipmentResponse;
import com.backend.demo.model.UserResponse;
import com.backend.demo.service.UserService;

@RestController
public class userController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/user")
	public ResponseEntity<?> getAllUsers() {
		List<Users> users=null;
		try {
			users=userService.findAllUsers();
			if(users.size()==0) {
				return new  ResponseEntity<>(new UserResponse("No Users Found"),HttpStatus.OK);	

			}else {
				return new ResponseEntity<>(new UserResponse("Users Retrived Successfully",users),HttpStatus.OK);

			}
		}catch (Exception e) {
			users=new ArrayList<Users>();
			return new  ResponseEntity<>(new UserResponse("Something ?Went Wrong",users),HttpStatus.NOT_FOUND);	
		}

	}
	

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Users user= null;
		List<Users> users =new ArrayList<Users>();
		try {
			user = userService.findById(id);
			users.add(user);
			return new ResponseEntity<>(new UserResponse("User Retrived Successfully", users), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new UserResponse("There is no user with this id", users),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/user")
	public ResponseEntity<?> addItem(@RequestBody Users user){
		Users myUser= null;
		List<Users> users =new ArrayList<Users>();
		
		try {
			myUser=userService.addUser(user);
			users.add(myUser);
			return new ResponseEntity<>(new UserResponse("user is added successfully", users), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new UserResponse("user can not added", users), HttpStatus.NOT_FOUND);

		}
	}
	
	@PutMapping(value = "/user")
	public ResponseEntity<?> updateItem(@RequestBody Users user){
		Users myUser= null;
		int id = user.getId();
		List<Users> users =new ArrayList<Users>();
		try {
			myUser=userService.updateUser(id, user);
			users.add(myUser);
			return new ResponseEntity<>(new UserResponse("user is updated Successfully", users),HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new UserResponse("user Can Not update this id doesnt exist", users),HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping(value="/user/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(new UserResponse("user is Deleted Successfully"),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new UserResponse("Can not delete this user,user id is not exist"),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "u/reset-password")
	public ResponseEntity<?> updatePassword(@RequestBody Map<String, Object> request){
		int phoneNumber=(int) request.get("phoneNumber");
		String newPassword=(String) request.get("password");
		try {
			userService.updatePassword(phoneNumber, newPassword);
			return new ResponseEntity<>(new UserResponse("Password is updated Successfully"),HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new UserResponse("This Agent is Not Exist please enter the right phone number"),HttpStatus.NOT_FOUND);
		}
	}
	
}
