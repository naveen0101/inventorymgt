package com.dxctraining.inventorymgt.phonemgt.dto;

public class UpdatePhoneRequest {
	
	private String name;
	private int storageSize;
    private int id;
	

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
	public int getStorageSize() {
		return storageSize;
	}
	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}
}
