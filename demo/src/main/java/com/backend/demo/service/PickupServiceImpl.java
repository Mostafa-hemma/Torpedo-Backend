package com.backend.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.PickupDao;
import com.backend.demo.entity.PickUp;
import com.backend.demo.entity.Shipment;
@Service
public class PickupServiceImpl implements PickupService {
	
	@Autowired
	private PickupDao pickupDao;

	@Override
	public List<PickUp> findAll() throws Exception {
		return pickupDao.findAll();
	}

	@Override
	public PickUp findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return pickupDao.findById(id).orElseThrow(()->new Exception());
	}

	@Override
	public PickUp addPickup(PickUp pickup) throws Exception {
		pickup.setId(0);
		return pickupDao.save(pickup);
	}

	@Override
	public PickUp updatePickup(int id, PickUp pickup) throws Exception {
		if(findById(id)==null) {
			throw new Exception();
		}
		PickUp myPickUp=pickupDao.save(pickup);		
		return myPickUp;
	}

	@Override
	public void deletePickup(int id) throws Exception {
		pickupDao.deleteById(id);
	}

}
