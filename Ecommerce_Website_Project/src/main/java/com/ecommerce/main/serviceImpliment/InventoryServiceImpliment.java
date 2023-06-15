package com.ecommerce.main.serviceImpliment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.model.Products;
import com.ecommerce.main.repository.ProductRepository;
import com.ecommerce.main.service.InventoryService;
@Service
public class InventoryServiceImpliment implements InventoryService {
	@Autowired
	ProductRepository productRepository;
	@Override
	public void saveproduct(Products product) {
		
		productRepository.save(product);
	}
	@Override
	public List<Products> getAllProducts() {
		List<Products> productList = productRepository.findAll();
		return productList;
	}
	@Override
	public List<Products> getproductByCategory(String productCatagory) {
		List<Products> productList = productRepository.findByProductCategory(productCatagory);
		return productList;
	}
	@Override
	public Products getproductByName(String productName) {
		  // TODO Auto-generated method stub
		return null;
	}

}
