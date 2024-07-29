package com.backend.demo.service;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.CustomerDao;
import com.backend.demo.dao.DeliveryAgentDao;
import com.backend.demo.dao.UserDao;
import com.backend.demo.entity.Customer;
import com.backend.demo.entity.DeliveryAgent;
import com.backend.demo.entity.Users;



@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private DeliveryAgentDao deliveryAgentDao;

	@Override
	public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
	     Users user = userDao.findByPhoneNumber(Integer.parseInt(phoneNumber)).orElse(null);
	        if (user != null) {
//	            return new org.springframework.security.core.userdetails.User(String.valueOf(user.getPhoneNumber()), user.getPassword(),
//	                    Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
	        	return new org.springframework.security.core.userdetails.User(String.valueOf(user.getPhoneNumber()), user.getPassword(), 
	                    user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
	        
	        }
	        
	        DeliveryAgent agent = deliveryAgentDao.findByPhoneNumber(Integer.parseInt(phoneNumber)).orElse(null);
	        if (agent != null) {
	            return new org.springframework.security.core.userdetails.User(String.valueOf(agent.getPhoneNumber()), agent.getPassword(),
	                    Collections.singletonList(new SimpleGrantedAuthority(agent.getRole())));
	        }
	        
	        Customer customer = customerDao.findByPhoneNumber(Integer.parseInt(phoneNumber)).orElseThrow(() -> new UsernameNotFoundException("User not found"));
	        return new org.springframework.security.core.userdetails.User(String.valueOf(customer.getPhoneNumber()), customer.getPassword(),
	                Collections.singletonList(new SimpleGrantedAuthority(customer.getRole())));
	    }
	}


