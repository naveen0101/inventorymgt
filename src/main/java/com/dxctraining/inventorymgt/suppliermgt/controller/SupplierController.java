package com.dxctraining.inventorymgt.suppliermgt.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.suppliermgt.dto.SessionData;
import com.dxctraining.inventorymgt.suppliermgt.entities.Supplier;
import com.dxctraining.inventorymgt.suppliermgt.service.*;

@Controller
public class SupplierController {

	@Autowired
	private ISupplierService supplierService;

        @Autowired
	private SessionData sessionData;
	
	@PostConstruct
	public void init() {
		

		Supplier supplier1 = new Supplier("cherry", "tejas");
		int id1 = supplier1.getId();
		supplier1 = supplierService.save(supplier1);

		Supplier supplier2 = new Supplier("jatin", "garikapati");
		int id2 = supplier1.getId();
		supplier2 = supplierService.save(supplier2);
		

	}
	
	@GetMapping("/supplier")
	public ModelAndView supplierdetails(@RequestParam("id") int id) {
		Supplier supplier = supplierService.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("supplierdetails", "supplier", supplier);
		return modelAndView;
	}
	
	@GetMapping("/allsuppliers")
	public ModelAndView allSuppliers() {
		List<Supplier>listAll = supplierService.allSuppliers();
		ModelAndView modelAndView = new ModelAndView("list","suppliers",listAll);
		return modelAndView;
		
	}
@GetMapping("/register")
	public ModelAndView registerSupplier() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("name") String name, @RequestParam("password") String password) {
		System.out.println("inside processregister method, name=" + name);
		Supplier supplier = new Supplier(name, password);
		supplier = supplierService.save(supplier);
		ModelAndView mv = new ModelAndView("supplierdetails", "supplier", supplier);
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@GetMapping("/processlogin")
	public ModelAndView processLogin( @RequestParam("id") int id, @RequestParam("password") String password) {
		boolean correct = supplierService.authenticate(id, password);
		if (!correct) {
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}
		sessionData.saveLogin(id);
		Supplier supplier = supplierService.findSupplierById(id);
		ModelAndView mv = new ModelAndView("supplierdetails", "supplier", supplier);
		return mv;
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		sessionData.clear();
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

}



