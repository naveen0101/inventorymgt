package com.dxctraining.inventorymgt.phonemgt.service;
import java.util.List;

import com.dxctraining.inventorymgt.phonemgt.entities.Phone;

public interface IPhoneService {
	
	void validate(Object arg);
	
	Phone save(Phone phone);
	
	Phone findPhoneById(int id);

	Phone remove(int id);

	List<Phone> allPhones();
	
	Phone add(Phone phone);

        Phone update(Phone phone);
}
