package com.ecommerce.main.service;

import java.util.List;

import com.ecommerce.main.model.Products;

public interface InventoryService {

	public void saveproduct(Products product);

	public List<Products> getAllProducts();

	public List<Products> getproductByCategory(String productCatagory);

	public Products getproductByName(String productName);

}
