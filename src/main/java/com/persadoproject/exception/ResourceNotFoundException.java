package com.persadoproject.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String identification) {
		super("Could not find resource with search term: " + identification);
	}
	public ResourceNotFoundException() {
		super("Could not find resource");
	}

}
