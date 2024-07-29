package com.backend.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.entity.Customer;
import com.backend.demo.entity.Item;
import com.backend.demo.model.CustomerResponse;
import com.backend.demo.model.ItemResponse;
import com.backend.demo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping(value = "/item")
	public ResponseEntity<?> findAll() {
		List<Item> items = null;
		try {
			items = itemService.findAll();
			if (items.size() != 0) {
				return new ResponseEntity<>(new ItemResponse("Items Retrived Successfully", items), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ItemResponse("There is no items in DB", items), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new ItemResponse("something went wrong", items), HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping(value = "/item/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Item item = null;
		List<Item> items =new ArrayList<Item>();
		try {
			item = itemService.findById(id);
			items.add(item);
			return new ResponseEntity<>(new ItemResponse("item Retrived Successfully", items), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ItemResponse("There is no item with this id", items),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/item")
	public ResponseEntity<?> addItem(@RequestBody Item item){
		Item myItem=null;
		List<Item> items =new ArrayList<Item>();

		try {
			myItem=itemService.addItem(item);
			items.add(myItem);

			return new ResponseEntity<>(new ItemResponse("item is added successfully", items), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(new ItemResponse("item can not added", items), HttpStatus.NOT_FOUND);

		}
	}
	
	@PutMapping(value = "/item")
	public ResponseEntity<?> updateItem(@RequestBody Item item){
	Item myItem=null;
	int id=item.getId();
	List<Item> items =new ArrayList<Item>();
		try {
			myItem=itemService.updateItem(id,item);
			items.add(myItem);
			return new ResponseEntity<>(new ItemResponse("Item is updated Successfully", items),HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ItemResponse("Item Can Not update this id doesnt exist", items),HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping(value="/item/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
		try {
			itemService.deleteItem(id);
			return new ResponseEntity<>(new CustomerResponse("Item is Deleted Successfully"),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new CustomerResponse("Can not delete this item,customer id is not exist"),HttpStatus.NOT_FOUND);
		}
	}

}
