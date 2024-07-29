package com.backend.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.ReceiverDao;
import com.backend.demo.entity.Receiver;
@Service
public class ReceiverServiceImpl implements ReceiverService {

	@Autowired
	private ReceiverDao receiverDao;
	
	@Override
	public List<Receiver> findAll() throws Exception {
		return receiverDao.findAll();
	}

	@Override
	public Receiver findById(int id) throws Exception {
		Receiver receiver=receiverDao.findById(id).orElseThrow(()-> new Exception());
		return receiver;
	}

	@Override
	public Receiver addReceiver(Receiver receiver) throws Exception {
		receiver.setId(0);
		Receiver myReceiver=receiverDao.save(receiver);
		return myReceiver;
	}

	@Override
	public Receiver updateReceiver(int id, Receiver receiver) throws Exception {
		if(findById(id)==null) {
			throw new Exception();
		}
		Receiver myReceiver=receiverDao.save(receiver);
		
		return myReceiver;
	}

	@Override
	public void deleteReceiver(int id) throws Exception {

		receiverDao.deleteById(id);
	}

}
