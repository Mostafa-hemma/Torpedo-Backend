package com.backend.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.demo.entity.CustomerAddress;

@Repository
public interface CustomerAddressDao extends JpaRepository<CustomerAddress, Integer> {

}
