package com.backend.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.UserDao;
import com.backend.demo.entity.Customer;
import com.backend.demo.entity.Receiver;
import com.backend.demo.entity.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Users> findAllUsers() throws Exception {
		return userDao.findAll();
	}

	@Override
	public Users findById(int id) throws Exception {
		return userDao.findById(id).orElseThrow(()->new Exception());
	}

	@Override
	public Users addUser(Users user) throws Exception {
		user.setId(0);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		return userDao.save(user);
	}

	@Override
	public Users updateUser(int id, Users user) throws Exception {
		if(findById(id)==null) {
			throw new Exception();
		}
		Users myUser=userDao.save(user);
		
		return myUser;
	}

	@Override
	public void deleteUser(int id) throws Exception {
		userDao.deleteById(id);
	}

	@Override
	public void updatePassword(int phoneNumber, String newPassword) throws Exception {
		
		Users myUser=userDao.findByPhoneNumber(phoneNumber).orElse(null);
		if(myUser==null) {
			throw new Exception();
		}
		myUser.setPassword(bCryptPasswordEncoder.encode(newPassword));
		userDao.save(myUser);
		
	}

	@Override
	public Users findByPhoneNumber(int phoneNumber) throws Exception {
		return userDao.findByPhoneNumber(phoneNumber).orElseThrow(()-> new Exception());
	}


}
