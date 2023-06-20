package com.ecommerce.main.serviceImpliment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.exceptionHandller.ProductNotFoundException;
import com.ecommerce.main.model.Products;
import com.ecommerce.main.repository.ProductRepository;
import com.ecommerce.main.service.InventoryService;
@Service
public  class InventoryServiceImpliment implements InventoryService {
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
		if(productList.isEmpty()) {
			throw new ProductNotFoundException("Product category Not Available");
		}
		else {
		return productList;
		}
	}

	@Override
	public List<Products>getproductByPrice(Double productPrice) {
		List<Products> productList = productRepository.findByProductPrice(productPrice);
		if(productList.isEmpty()) {
			throw new ProductNotFoundException("Product Not Available");

		}
		else {
		return productList;
		}
	}
	@Override
	public Products getProductById(Integer productId) {
		Optional<Products> product= productRepository.findById(productId);
		return product.get();
	}
	@Override
	public Optional<Products> getProductByIdOptional(Integer productId) {
		Optional<Products> optional = productRepository.findById(productId);
		return optional;
	}


}
