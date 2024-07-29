package com.backend.demo.authenticatemodel;

import org.springframework.security.core.userdetails.UserDetails;

import com.backend.demo.entity.Customer;
import com.backend.demo.entity.DeliveryAgent;
import com.backend.demo.entity.Users;

public class AuthenticationResponse {

	private String message;
	private String jwt;
	private Customer myCustomer;
	private DeliveryAgent agent;
	private Users user;

	public AuthenticationResponse(String message, String jwt,Customer myCustomer) {
		this.jwt = jwt;
		this.message = message;
		this.myCustomer=myCustomer;
	}
	public AuthenticationResponse(String message, String jwt, DeliveryAgent agent) {
		this.jwt = jwt;
		this.message = message;
		this.agent=agent;
	}
	public AuthenticationResponse(String message, String jwt, Users user) {
		this.jwt = jwt;
		this.message = message;
		this.user=user;
	}


	public AuthenticationResponse(String message) {
		this.message = message;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public Customer getMyCustomer() {
		return myCustomer;
	}



	public void setMyCustomer(Customer myCustomer) {
		this.myCustomer = myCustomer;
	}
	public DeliveryAgent getAgent() {
		return agent;
	}
	public void setAgent(DeliveryAgent agent) {
		this.agent = agent;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

	


}
