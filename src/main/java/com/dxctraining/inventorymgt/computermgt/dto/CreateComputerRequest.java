package com.dxctraining.inventorymgt.computermgt.dto;

public class UpdateComputerRequest {
	private String name;
	private int diskSize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}
	
}
