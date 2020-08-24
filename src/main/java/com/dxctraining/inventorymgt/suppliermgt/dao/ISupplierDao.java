package com.dxctraining.inventorymgt.suppliermgt.dao;

import com.dxctraining.inventorymgt.suppliermgt.entities.*;
import java.util.*;

public interface ISupplierDao {

	Supplier save(Supplier supplier);

	Supplier findSupplierById(int id);

	Supplier remove(int id);

	List<Supplier> allSuppliers();
	
	Supplier update(Supplier supplier);
	
	void add(Supplier supplier);

}
