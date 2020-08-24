package com.dxctraining.inventorymgt.computermgt.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.computermgt.entities.Computer;
import com.dxctraining.inventorymgt.computermgt.service.IComputerService;
import com.dxctraining.inventorymgt.itemmgt.entities.Item;
import com.dxctraining.inventorymgt.suppliermgt.entities.Supplier;
import com.dxctraining.inventorymgt.suppliermgt.service.ISupplierService;



@Controller
public class ComputerController  extends Item {
	
	@Autowired
	private IComputerService computerService;
	@Autowired
        private ISupplierService supplierservice;
	
	@PostConstruct
	public void init() {
		
		Supplier supplier1= new Supplier("naveen", "kumar");
		supplier1=supplierservice.save(supplier1);
		Supplier supplier2= new Supplier("chotu", "chinnu");
        supplier2=supplierservice.save(supplier2);
		
		Computer computer1 = new Computer("Macbook",4239);
		computer1=computerService.save(computer1);
		
		Computer computer2 = new Computer("MacbookAir",9045);
		computer1=computerService.save(computer2);
		
	}
	
	
	@GetMapping("/computer")
	public ModelAndView computerdetails(@RequestParam("id") int id) {
		Computer computer = computerService.findComputerById(id);
		ModelAndView modelAndView = new ModelAndView("computerdetails", "computer", computer);
		return modelAndView;
	}
	
	@GetMapping("/allcomputers")
	public ModelAndView allComputers() {
		List<Computer>listAll = computerService.allComputers();
		ModelAndView modelAndView = new ModelAndView("computerlist","computer",listAll);
		return modelAndView;
		
	}
        @GetMapping("/computerregister")
	public ModelAndView registerComputer() {
		ModelAndView mv = new ModelAndView("computerregister");
		return mv;
	}

	@GetMapping("/computerprocessregister")
	public ModelAndView processRegister(@RequestParam("name") String name, @RequestParam("diskSize") int diskSize) {
		System.out.println("inside processregister method, name=" + name);
		Computer computer = new Computer(name,diskSize);
		computer = computerService.save(computer);
		ModelAndView mv = new ModelAndView("computerdetails", "computer", computer);
		return mv;
	}
	
}