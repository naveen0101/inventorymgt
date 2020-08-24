package com.dxctraining.inventorymgt.itemmgt.service;

import java.util.List;

import com.dxctraining.inventorymgt.itemmgt.entities.*;

public interface IItemService {
	
	void validate(Object arg);
	
	Item save(Item item);

	Item findItemById(int id);
	
	Item remove(int id);

	List<Item> allSuppliers();
}
	


