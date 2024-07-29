package com.backend.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.demo.dao.ItemDao;
import com.backend.demo.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Override
	public List<Item> findAll() throws Exception {

		return itemDao.findAll();
	}

	@Override
	public Item findById(int id) throws Exception {
		Item item = itemDao.findById(id).orElseThrow(() -> new Exception());
		return item;
	}

	@Override
	public Item addItem(Item item) throws Exception {

		item.setId(0);
		Item myItem = itemDao.save(item);
		return myItem;
	}

	@Override
	public Item updateItem(int id, Item item) throws Exception {

		if (findById(id) == null) {
			throw new Exception();
		}
		Item myItem = itemDao.save(item);
		return myItem;

	}

	@Override
	public void deleteItem(int id) throws Exception {
		itemDao.deleteById(id);
	}

}
