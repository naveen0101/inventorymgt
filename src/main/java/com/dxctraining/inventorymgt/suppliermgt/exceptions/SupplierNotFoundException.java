package com.dxctraining.inventorymgt.suppliermgt.exceptions;

public class SupplierNotFoundException  extends RuntimeException {
	public SupplierNotFoundException(String msg) {
		super(msg);
	}
}