package com.backend.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.demo.entity.Shipment;
@Repository
public interface ShipmentDao extends JpaRepository<Shipment, Integer>{

}
