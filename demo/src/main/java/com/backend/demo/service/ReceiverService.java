package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.Receiver;


public interface ReceiverService {
	
	public List<Receiver> findAll() throws Exception;
	public Receiver findById(int id) throws Exception;
	public Receiver addReceiver(Receiver receiver) throws Exception;
	public Receiver updateReceiver(int id,Receiver receiver) throws Exception;
	public void deleteReceiver(int id) throws Exception;

}
