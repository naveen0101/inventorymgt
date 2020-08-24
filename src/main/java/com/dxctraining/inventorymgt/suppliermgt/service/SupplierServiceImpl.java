package com.dxctraining.inventorymgt.suppliermgt.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.suppliermgt.dao.*;
import com.dxctraining.inventorymgt.suppliermgt.entities.*;
import com.dxctraining.inventorymgt.suppliermgt.exceptions.*;
import java.util.*;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ISupplierDao supplierDao;
	@Override
	public void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("Argument is null");
		}
	}

	@Override
	public Supplier save(Supplier supplier) {
		validate(supplier);
		supplierDao.save(supplier);
		return supplier;
	}
	@Override
	public Supplier findSupplierById(int id) {
		validate(id);
		Supplier supplier = supplierDao.findSupplierById(id);
		return supplier;
	}
		@Override
		public Supplier remove(int id) {
			validate(id);
			return supplierDao.remove(id);

		}

		@Override
		 public List<Supplier> allSuppliers(){
	        List<Supplier>allsuppliers=supplierDao.allSuppliers();
	        return allsuppliers;
		}
		  @Override
		    public boolean authenticate(int id, String password){
		       Supplier supplier= supplierDao.findSupplierById(id);
		       String storedPassword=supplier.getPassword();
		       boolean equals= storedPassword.equals(password);
		       return equals;

		     
		    }
		  @Override
			public Supplier update(Supplier supplier) {
				validate(supplier);
				supplierDao.update(supplier);
				return supplier;
			}
		  @Override
			public Supplier add(Supplier supplier) {
				validate(supplier);
				supplierDao.add(supplier);
				return supplier;
			}


}