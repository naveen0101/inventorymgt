package com.dxctraining.inventorymgt.phonemgt.dto;

public class CreatePhoneRequest {
	
	private String name;
	private int storageSize;
	
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
