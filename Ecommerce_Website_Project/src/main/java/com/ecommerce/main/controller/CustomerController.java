package com.ecommerce.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.model.Products;
import com.ecommerce.main.service.InventoryService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private InventoryService inventotyService;
	
	@GetMapping(value = "/viewProductByCategory/{productCategory}")
	public ResponseEntity<List<Products>> viewProductByCategory(@PathVariable String productCategory){
	    List<Products> productList = inventotyService.getproductByCategory(productCategory);
		return new ResponseEntity<List<Products>>(productList,HttpStatus.OK);
		
	}
	

}
