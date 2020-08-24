package com.dxctraining.inventorymgt.suppliermgt.service;

import com.dxctraining.inventorymgt.suppliermgt.entities.*;
import java.util.*;

public interface ISupplierService {

	void validate(Object obj);

	Supplier save(Supplier supplier);

	Supplier findSupplierById(int id);

	Supplier remove(int id);

	List<Supplier> allSuppliers();

	boolean authenticate(int id, String password);
	
	Supplier update(Supplier supplier);
	
	Supplier add(Supplier supplier);

}
