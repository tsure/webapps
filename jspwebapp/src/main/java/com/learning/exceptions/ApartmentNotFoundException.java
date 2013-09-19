package com.learning.exceptions;

public class ApartmentNotFoundException extends Exception {
	
	public ApartmentNotFoundException() {
		
	}
	
	public ApartmentNotFoundException(String message) {
		super(message);
	}

}
