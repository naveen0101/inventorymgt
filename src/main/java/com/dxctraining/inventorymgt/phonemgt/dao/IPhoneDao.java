package com.dxctraining.inventorymgt.phonemgt.dao;

import java.util.List;

import com.dxctraining.inventorymgt.phonemgt.entities.*;

public interface IPhoneDao {

        Phone save(Phone phone);

	Phone findPhoneById(int id);

	Phone remove(int id);

	List<Phone> allPhones();
	
	Phone add(Phone phone);

        Phone update(Phone phone);
}
