package com.dxctraining.inventorymgt.itemmgt.exceptions;

public class ItemNotFoundException  extends RuntimeException {
	public ItemNotFoundException(String msg) {
		super(msg);
	}
}