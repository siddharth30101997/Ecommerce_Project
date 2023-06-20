package com.ecommerce.main.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.main.model.ProductFeatures;
import com.ecommerce.main.model.Products;

public interface InventoryService {

	public void saveproduct(Products product);

	public List<Products> getAllProducts();

	public List<Products> getproductByCategory(String productCatagory);


	public List<Products> getproductByPrice(Double productPrice);

	public Products getProductById(Integer productId);

	public Optional<Products> getProductByIdOptional(Integer productId);

	public ProductFeatures getProductFeatures(Integer featureId);

	

	
}
