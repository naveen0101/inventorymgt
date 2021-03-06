package com.dxctraining.inventorymgt.centralexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dxctraining.inventorymgt.computermgt.exceptions.ComputerNotFoundException;
import com.dxctraining.inventorymgt.computermgt.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.phonemgt.exceptions.PhoneNotFoundException;
import com.dxctraining.inventorymgt.suppliermgt.exceptions.SupplierNotFoundException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	 @ExceptionHandler(SupplierNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public String handleEmployeeNotFound(SupplierNotFoundException e){
	        System.out.println("inside handlePhoneNotNotFound");
	        String msg=e.getMessage();
	        return msg;
	    }

	    @ExceptionHandler(InvalidArgumentException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handleInvalidArgument(InvalidArgumentException e){
	        System.out.println("inside handleInvalidArgument");
	        return e.getMessage();
	    }
	    @ExceptionHandler(PhoneNotFoundException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handlePhoneNotFoundException(PhoneNotFoundException e){
	        System.out.println("inside handleInvalidArgument");
	        String msg=e.getMessage();
	        return msg;
	    }
	    @ExceptionHandler(ComputerNotFoundException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handleComputerNotFoundException(ComputerNotFoundException e){
	        System.out.println("inside handleInvalidArgument");
	        String msg=e.getMessage();
	        return msg;
	    }
}

