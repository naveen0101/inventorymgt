package com.dxctraining.inventorymgt.ui;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.computermgt.entities.Computer;
import com.dxctraining.inventorymgt.computermgt.exceptions.ComputerNotFoundException;
import com.dxctraining.inventorymgt.computermgt.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.computermgt.service.IComputerService;
import com.dxctraining.inventorymgt.itemmgt.entities.Item;
import com.dxctraining.inventorymgt.itemmgt.exceptions.ItemNotFoundException;
import com.dxctraining.inventorymgt.itemmgt.service.IItemService;
import com.dxctraining.inventorymgt.phonemgt.entities.Phone;
import com.dxctraining.inventorymgt.phonemgt.exceptions.PhoneNotFoundException;
import com.dxctraining.inventorymgt.phonemgt.service.IPhoneService;
import com.dxctraining.inventorymgt.suppliermgt.entities.Supplier;
import com.dxctraining.inventorymgt.suppliermgt.exceptions.SupplierNotFoundException;
import com.dxctraining.inventorymgt.suppliermgt.service.ISupplierService;


@Component
public class MainUi {

	@Autowired
	private ISupplierService supplierservice;

	@Autowired

	private IItemService itemservice;
	
	@Autowired
	private IPhoneService phoneservice;
	
	@Autowired
	private IComputerService computerService;
	
	
	
	

	@PostConstruct
	public void runApp() {
	try {
		Supplier supplier1 = new Supplier("naveen","kumar");
		supplier1 = supplierservice.save(supplier1);
		int id1 = supplier1.getId();
		Supplier supplier2 = new Supplier("pavan","kumar");
		supplier2 = supplierservice.save(supplier2);
		int id2 = supplier2.getId();

		System.out.println("---Sprint 1 completed---");

		Item item1 = new Item("Mouse", supplier1);
		item1 = itemservice.save(item1);
		Item item2 = new Item("Charger", supplier2);
		item2 = itemservice.save(item2);

		System.out.println("---Sprint 2 completed---");

		Phone phone1 = new Phone("Realme",12);
		phone1 = phoneservice.save(phone1);
		Phone phone2 = new Phone("Apple",32);
		phone1 = phoneservice.save(phone2);

		System.out.println("---Sprint 3 completed---");

		Computer comp1 = new Computer("HP", 238);
		comp1 = computerService.save(comp1);
		Computer comp2 = new Computer("Lenovo",228);
		comp2 = computerService.save(comp2);

		System.out.println("---Sprint 4 completed---");

		Supplier supplierFetched = supplierservice.findSupplierById(id1);
		Phone phoneFetched = phoneservice.findPhoneById(5);
		Computer compFetched = computerService.findComputerById(7);
		System.out.println("Fetched Supplier= " + supplierFetched.getName() + " Id= " + supplierFetched.getId());
		System.out.println("Phone details= " + phoneFetched.getName() + " Id= " + phoneFetched.getId()+" Storage size in GB= " + phoneFetched.getStorageSize());
		System.out.println("Computer details= " + compFetched.getName() + " Id= " + compFetched.getId()+" Disk Size in GB= " + compFetched.getDiskSize());

	} catch (InvalidArgumentException e) {
		e.printStackTrace();
	} catch (SupplierNotFoundException e) {
		e.printStackTrace();
	} catch (ItemNotFoundException e) {
		e.printStackTrace();
	} catch (PhoneNotFoundException e) {
		e.printStackTrace();
	} catch (ComputerNotFoundException e) {
		e.printStackTrace();
	}
}
}
