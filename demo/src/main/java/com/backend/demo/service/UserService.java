package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.Shipment;
import com.backend.demo.entity.Users;

public interface UserService {
	
	public List<Users> findAllUsers() throws Exception;
	public Users findById(int id) throws Exception;
	public Users addUser(Users user) throws Exception;
	public Users updateUser(int id,Users user) throws Exception;
	public Users findByPhoneNumber(int phoneNumber) throws Exception;
	public void deleteUser(int id) throws Exception;
	public void updatePassword(int phoneNumber,String newPassword) throws Exception;
		
}
