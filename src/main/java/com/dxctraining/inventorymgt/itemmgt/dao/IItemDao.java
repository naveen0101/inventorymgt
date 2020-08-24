package com.dxctraining.inventorymgt.itemmgt.dao;

import java.util.List;

import com.dxctraining.inventorymgt.itemmgt.entities.*;

	public interface IItemDao {

	Item save(Item item);

	Item findItemById(int id);
	
	Item remove(int id);

	List<Item> allSuppliers();
		

	}
