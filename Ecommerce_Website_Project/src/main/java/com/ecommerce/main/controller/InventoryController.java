package com.ecommerce.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.main.exceptionHandller.ProductNotFoundException;
import com.ecommerce.main.model.ProductFeatures;
import com.ecommerce.main.model.Products;
import com.ecommerce.main.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin("*")
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
	
	@GetMapping(value = "/getProductById/{productId}")
	public ResponseEntity<Products> getProductById(@PathVariable Integer productId) {
		Products product = inventoryService.getProductById(productId);
		return new ResponseEntity<Products>(product, HttpStatus.OK);
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
	@PutMapping(value = "/updateProduct/{productId}")
	public ResponseEntity<String> updateProduct(@RequestParam("product") String product,
			@RequestParam("productPhoto") MultipartFile multipartfile,@PathVariable Integer productId) throws IOException{
		
		Optional<Products> escistingProduct = inventoryService.getProductByIdOptional(productId);
		if(escistingProduct.isPresent()) {
			ObjectMapper objectmapper=new ObjectMapper();  
			
			Products productData = objectmapper.readValue(product, Products.class);
//			List<ProductFeatures> productfeatures = productData.getProductDetails().getProductfeatures();
//			for (ProductFeatures feature : productfeatures) {
//				Integer featureId = feature.getProductFeatureId();
//			ProductFeatures pf	=inventoryService.getProductFeatures(featureId);
//			if(pf!=null) {
//				
//			}
//			}
			System.out.println(productData.getProductCategory());
			
			productData.setProductPhoto(multipartfile.getBytes());
			inventoryService.saveproduct(productData);
			
			return new ResponseEntity<String>("Products update successfully", HttpStatus.CREATED);
		}
		else {
			throw new ProductNotFoundException("product you want to update is not presnt");
		}
		
		
		
	}

}
