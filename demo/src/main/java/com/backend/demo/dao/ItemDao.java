package com.backend.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.demo.entity.Item;
@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {

}
