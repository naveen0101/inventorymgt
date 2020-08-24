package com.dxctraining.inventorymgt.computermgt.dao;

import java.util.List;

import com.dxctraining.inventorymgt.computermgt.entities.*;

public interface IComputerDao  {
	
	Computer save(Computer computer);

	Computer findComputerById(int id);

	Computer remove(int id);

	List<Computer> allComputers();
	
	Computer add(Computer computer);

       Computer update(Computer computer);
}
	

	

