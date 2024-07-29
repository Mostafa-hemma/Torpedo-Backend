package com.backend.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.ShipmentDao;
import com.backend.demo.entity.Shipment;
@Service
public class ShipmentServiceImpl implements ShipmentService {
	
	@Autowired
	private ShipmentDao shipmentDao;

	@Override
	public List<Shipment> findAll() throws Exception {
		return shipmentDao.findAll();
	}

	@Override
	public Shipment findById(int id) throws Exception {
		Shipment shipment=shipmentDao.findById(id).orElseThrow(()->new Exception());
		return shipment;
	}
	@Transactional
	@Override
	public Shipment addShipment(Shipment shipment) throws Exception {
		shipment.setId(0);
		Shipment myShipment=shipmentDao.save(shipment);
		return myShipment;
	}

	@Override
	public Shipment updateShipment(int id, Shipment shipment) throws Exception {
		if(findById(id)==null) {
			throw new Exception();
		}
		Shipment myShipment=shipmentDao.save(shipment);

		return myShipment;
	}

	@Override
	public void deleteShipment(int id) throws Exception {
		System.out.println("helloooooo "+id);
		shipmentDao.deleteById(id);
	}

}
