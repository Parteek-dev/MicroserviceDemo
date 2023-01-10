package com.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(){
		super("Resouce not found on server !!");
	}
	
}
