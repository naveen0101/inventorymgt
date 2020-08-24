package com.dxctraining.inventorymgt.computermgt.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.itemmgt.entities.Item;
import com.dxctraining.inventorymgt.suppliermgt.entities.Supplier;

@Entity
@Table(name="computer_details")
public class Computer extends Item {

	private int diskSize;
	private String name;

	
	public Computer( String name,int diskSize) {
		this.name=name;
		this.diskSize=diskSize;
	}
	
	public Computer() {
		
	}

	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}
        public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Computer that = (Computer) obj;
		return diskSize == that.diskSize;
	}

	@Override
	public int hashCode() {
		return getId();
	}

}
