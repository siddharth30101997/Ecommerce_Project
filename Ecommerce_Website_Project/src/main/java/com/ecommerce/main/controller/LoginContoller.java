package com.ecommerce.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.model.UserDetails;
import com.ecommerce.main.service.LoginService;
@CrossOrigin("*")
@RestController
@RequestMapping("login")
public class LoginContoller {
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value = "getUserNameAndPassword/{userName}/{password}")
	public ResponseEntity<UserDetails> getUserDetailsByUserNameAndPassword(@PathVariable String userName,@PathVariable String password){
		UserDetails userDetails = loginService.getUserDetailsByUserNameAndPassword(userName,password);
		return new ResponseEntity<UserDetails>(userDetails,HttpStatus.OK);
	}

}
