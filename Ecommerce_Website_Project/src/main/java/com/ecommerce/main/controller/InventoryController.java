package com.ecommerce.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.model.Products;
import com.ecommerce.main.service.InventoryService;

@RestController
@RequestMapping("inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@PostMapping(value = "/createEmployee")
	public ResponseEntity<String> createProduct(@RequestBody Products product){
		
		inventoryService.saveproduct(product);
		return new ResponseEntity<String>("Products Created", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> productList=inventoryService.getAllProducts();
		return new ResponseEntity<List<Products>>(productList,HttpStatus.OK);
	}
//	@GetMapping(value = "/getproductByName/{productName}")
//	public ResponseEntity<Products> getproductByName(@PathVariable String productName){
//		Products getproductByCategory = inventoryService.getproductByCategory(productName);
//		
//		return new ResponseEntity<Products>(getproductByCategory,HttpStatus.OK);
//		
// 	}
	
	
	@GetMapping(value = "/viewProductByCategory/{productCatagory}")
	public ResponseEntity<List<Products>> viewProductByCategory(@PathVariable String productCatagory ){
		List<Products> productList = inventoryService.getproductByCategory(productCatagory);
		
		return new ResponseEntity<List<Products>>(productList,HttpStatus.OK);
		
	}

}