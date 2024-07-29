package com.backend.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.demo.entity.Customer;
import com.backend.demo.entity.Users;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	Optional<Customer> findByPhoneNumber(int phoneNumber);

}
