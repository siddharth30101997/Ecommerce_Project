package com.ecommerce.main.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.ecommerce.main.model.Customer;
import com.ecommerce.main.model.ProductDetails;
import com.ecommerce.main.model.Products;
import com.ecommerce.main.model.UserDetails;
import com.ecommerce.main.service.CustomerService;
import com.ecommerce.main.service.InventoryService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value ="/createCustomer")
	public ResponseEntity<String> savecustomer(@RequestBody Customer customer){
		UserDetails user=new UserDetails();
		user.setUserType("customer");
	
		user.setUserName(customer.getCustomerUserDetails().getUserName());
		user.setPassword(customer.getCustomerUserDetails().getPassword());
		customer.setCustomerUserDetails(user);
		customerService.savecustomer(customer);
		return new ResponseEntity<String>("Customer Created", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/viewProductByCategory/{productCategory}")
	public ResponseEntity<List<Products>> viewProductByCategory(@PathVariable String productCategory){
	    List<Products> productList = inventoryService.getproductByCategory(productCategory);
		return new ResponseEntity<List<Products>>(productList,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> productList=inventoryService.getAllProducts();
		return new ResponseEntity<List<Products>>(productList,HttpStatus.OK);
	}

	@GetMapping(value = "/viewProductsByPrice/{productPrice}")	
	public ResponseEntity<List<Products>>viewProductsByPrice(@PathVariable Double productPrice){
		List<Products> productList = inventoryService.getproductByPrice(productPrice);
		return new ResponseEntity<List<Products>>(productList,HttpStatus.OK);
	}

	@GetMapping(value = "/viewProductsByName/{productName}")
	public ResponseEntity<List<Products>> viewProductsByName(@PathVariable String productName) {

		List<Products> productList = inventoryService.getAllProducts();
		List<Products> productListByName = new ArrayList<>();
		for (Products products : productList) {
			if (products.getProductDetails().getProductName().equals(productName)) {
				productListByName.add(products);
			}

		}

		return new ResponseEntity<List<Products>>(productListByName, HttpStatus.OK);
	}
	

}
