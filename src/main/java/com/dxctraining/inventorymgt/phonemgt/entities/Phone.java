package com.dxctraining.inventorymgt.phonemgt.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.itemmgt.entities.*;
import com.dxctraining.inventorymgt.suppliermgt.entities.Supplier;

@Entity
@Table(name="phone_details")
public class Phone extends Item {

private String name;	
private int storageSize;

public Phone(String name, int storageSize) {
	this.name=name;
	this.storageSize=storageSize;
}

public Phone() {
	
}
public String getName() {
     return name;
	}

public void setName(String name) {
	this.name = name;
	}
public int getStorageSize() {
	return storageSize;
}

public void setStoragesize(int storageSize) {
	this.storageSize = storageSize;
}
public int hashCode()
{
	return getId(); 
}
public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass() ) {
			return false;
		}
		Phone that = (Phone) obj;
		return this.storageSize == that.storageSize;

	}

}
