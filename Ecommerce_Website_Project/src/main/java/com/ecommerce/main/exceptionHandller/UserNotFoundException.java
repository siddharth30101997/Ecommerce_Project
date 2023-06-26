package com.ecommerce.main.exceptionHandller;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String messege) {
		super(messege);
	}

}
