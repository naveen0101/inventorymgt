package com.dxctraining.inventorymgt.phonemgt.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.itemmgt.entities.Item;
import com.dxctraining.inventorymgt.phonemgt.entities.Phone;
import com.dxctraining.inventorymgt.phonemgt.service.IPhoneService;
import com.dxctraining.inventorymgt.suppliermgt.entities.Supplier;
import com.dxctraining.inventorymgt.suppliermgt.service.ISupplierService;


@Controller
public class PhoneController extends Item {
	
	@Autowired
	private IPhoneService phoneservice;
        @Autowired
        private ISupplierService supplierservice;

	@PostConstruct
	public void init() {
		
        Supplier supplier1= new Supplier("naveen", "stark");
		supplier1=supplierservice.save(supplier1);
		Supplier supplier2= new Supplier("chotu", "jasper");
		supplier2=supplierservice.save(supplier2);

		Phone ph1 = new Phone("oneplus",12389);
		ph1=phoneservice.save(ph1);
		Phone ph2 = new Phone("vivo",43589);
		ph2=phoneservice.save(ph2);
		
	}
	
	@GetMapping("/phone")
	public ModelAndView phonedetails(@RequestParam("id") int id) {
		Phone phone = phoneservice.findPhoneById(id);
		ModelAndView modelAndView = new ModelAndView("phonedetails", "phone", phone);
		return modelAndView;
	}
	
	@GetMapping("/allphones")
	public ModelAndView allPhones() {
		List<Phone>listAll = phoneservice.allPhones();
		ModelAndView modelAndView = new ModelAndView("phonelist","suppliers",listAll);
		return modelAndView;
		
	}
	
        @GetMapping("/phoneregister")
	public ModelAndView registerSupplier() {
		ModelAndView mv = new ModelAndView("phoneregister");
		return mv;
	}

	@GetMapping("/phoneprocessregister")
	public ModelAndView processRegister(@RequestParam("name") String name, @RequestParam("storageSize") int storageSize) {
		System.out.println("inside processregister method, name=" + name);
		Phone phone = new Phone(name,storageSize);
		phone = phoneservice.save(phone);
		ModelAndView mv = new ModelAndView("phonedetails", "phone", phone);
		return mv;
	}
	
	
	
}
