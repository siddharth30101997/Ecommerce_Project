package com.ecommerce.main.exceptionHandller;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(String messege) {
		super(messege);
	}

}
