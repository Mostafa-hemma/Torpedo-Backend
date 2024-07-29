package com.backend.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.DeliveryAgentDao;
import com.backend.demo.entity.DeliveryAgent;
@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DeliveryAgentDao deliveryAgentDao;

	@Override
	public List<DeliveryAgent> findAll() throws Exception {
		return deliveryAgentDao.findAll();
	}

	@Override
	public DeliveryAgent findById(int id) throws Exception {
		DeliveryAgent agent=deliveryAgentDao.findById(id).orElseThrow(() -> new Exception());
		return agent;
	}

	@Override
	public DeliveryAgent addDeliveryAgent(DeliveryAgent deliveryAgent) throws Exception {
		deliveryAgent.setId(0);
		deliveryAgent.setRole("ROLE_AGENT");
		deliveryAgent.setPassword(bCryptPasswordEncoder.encode(deliveryAgent.getPassword()));

		DeliveryAgent agent=deliveryAgentDao.save(deliveryAgent);
		return agent;
	}

	@Override
	public DeliveryAgent updateDeliveryAgent(int id, DeliveryAgent deliveryAgent) throws Exception {
		if(findById(id)==null) {
			throw new Exception();
		}
		deliveryAgent.setRole("ROLE_AGENT");
		deliveryAgent.setPassword(bCryptPasswordEncoder.encode(deliveryAgent.getPassword()));

		DeliveryAgent agent=deliveryAgentDao.save(deliveryAgent);
		return agent;
	}

	@Override
	public void deleteDeliveryAgent(int id) throws Exception {
		deliveryAgentDao.deleteById(id);
	}

	@Override
	public void updatePassword(int phoneNumber, String newPassword) throws Exception {

		DeliveryAgent myAgent=deliveryAgentDao.findByPhoneNumber(phoneNumber).orElse(null);
		if(myAgent==null) {
			throw new Exception();
		}else {
			myAgent.setPassword(bCryptPasswordEncoder.encode(newPassword));
			deliveryAgentDao.save(myAgent);
		}
		
	}

	@Override
	public DeliveryAgent findByPhoneNumber(int phoneNumber) throws Exception {
		DeliveryAgent agent= deliveryAgentDao.findByPhoneNumber(phoneNumber).orElseThrow(()-> new Exception());
		return agent;
	}

}
