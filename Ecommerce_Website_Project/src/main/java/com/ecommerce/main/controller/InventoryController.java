package com.ecommerce.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.main.model.Products;
import com.ecommerce.main.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

//	@PostMapping(value = "/createProduct")
//	public ResponseEntity<String> createProduct(@RequestBody Products product) {
//
//		inventoryService.saveproduct(product);
//		return new ResponseEntity<String>("Products Created", HttpStatus.CREATED);
//	}
	
	@PostMapping(value = "/createProduct")
	public ResponseEntity<String> createProduct(@RequestParam("product") String product,
			@RequestParam("productPhoto") MultipartFile multipartfile) throws IOException {
		
		ObjectMapper objectmapper=new ObjectMapper();
		
		Products productData = objectmapper.readValue(product, Products.class);
		
		System.out.println(productData.getProductCategory());
		
		productData.setProductPhoto(multipartfile.getBytes());
		inventoryService.saveproduct(productData);
		
		return new ResponseEntity<String>("Products Created", HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<List<Products>> getAllProducts() {
		List<Products> productList = inventoryService.getAllProducts();
		return new ResponseEntity<List<Products>>(productList, HttpStatus.OK);
	}

	@GetMapping(value = "/getproductByName/{productName}")
	public ResponseEntity<List<Products>> getproductByName(@PathVariable String productName) {
		List<Products> productByNameList = new ArrayList<>();
		List<Products> productList = inventoryService.getAllProducts();
		for (Products products : productList) {
			if (products.getProductDetails().getProductName().equals(productName)) {
				productByNameList.add(products);
			}
		}

		return new ResponseEntity<List<Products>>(productByNameList, HttpStatus.OK);

	}

	@GetMapping(value = "/viewProductByCategory/{productCatagory}")
	public ResponseEntity<List<Products>> viewProductByCategory(@PathVariable String productCatagory) {
		List<Products> productList = inventoryService.getproductByCategory(productCatagory);

		return new ResponseEntity<List<Products>>(productList, HttpStatus.OK);

	}

}
