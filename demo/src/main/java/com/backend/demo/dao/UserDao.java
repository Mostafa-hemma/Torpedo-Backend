package com.backend.demo.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.demo.entity.Users;
@Repository
public interface UserDao extends JpaRepository<Users, Integer>{
//	
Optional<Users> findByPhoneNumber(int phoneNumber);
//public Users findByPhoneNumberAndPassword(int phoneNumber,String password);
}
