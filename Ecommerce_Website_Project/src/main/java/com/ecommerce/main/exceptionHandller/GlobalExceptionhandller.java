package com.ecommerce.main.exceptionHandller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandller {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundExceptionHandller(ProductNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> EmployeeNotFoundException(EmployeeNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}

}