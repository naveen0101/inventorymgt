package com.dxctraining.inventorymgt.itemmgt.entities;

import javax.persistence.*;


import com.dxctraining.inventorymgt.suppliermgt.entities.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name ="item_details")

public class Item {
	@Id
	@GeneratedValue
private int id;
private String name;
@ManyToOne
private Supplier supplier;
 public Item(String name,Supplier supplier) {
	this.name=name;
	this.supplier=supplier;
}
 public Item() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
@Override
public int hashCode() {
	
	return id;
}
@Override
public boolean equals(Object arg) {
	if(this==arg) {
		return true;
	}
	
   if(arg==null || !(arg instanceof Item) ) {
		return false;
   }
	
    Item that=(Item)arg;	
	boolean isequal=this.id==that.id;
	return isequal;
}
}
