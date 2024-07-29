package com.backend.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.demo.entity.Receiver;
@Repository
public interface ReceiverDao extends JpaRepository<Receiver, Integer> {

}
