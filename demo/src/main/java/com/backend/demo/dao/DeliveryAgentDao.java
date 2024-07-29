package com.backend.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.demo.entity.Customer;
import com.backend.demo.entity.DeliveryAgent;

@Repository
public interface DeliveryAgentDao extends JpaRepository<DeliveryAgent, Integer> {
	Optional<DeliveryAgent> findByPhoneNumber(int phoneNumber);
}
