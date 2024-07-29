package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.Item;

public interface ItemService {
	
	public List<Item> findAll() throws Exception;
	public Item findById(int id) throws Exception;
	public Item addItem(Item item) throws Exception;
	public Item updateItem(int id,Item item) throws Exception;
	public void deleteItem(int id) throws Exception;

}
