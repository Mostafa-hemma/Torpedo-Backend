package com.backend.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.demo.entity.PickUp;

public interface PickupDao extends JpaRepository<PickUp, Integer> {
	
//	List<PickUp> FindByCustomerId(int id);

}
