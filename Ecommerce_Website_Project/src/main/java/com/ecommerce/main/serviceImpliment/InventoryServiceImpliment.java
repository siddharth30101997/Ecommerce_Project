package com.ecommerce.main.serviceImpliment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.exceptionHandller.ProductNotFoundException;
import com.ecommerce.main.model.ProductFeatures;
import com.ecommerce.main.model.Products;
import com.ecommerce.main.repository.ProductFeaturesrepository;
import com.ecommerce.main.repository.ProductRepository;
import com.ecommerce.main.service.InventoryService;
@Service
public  class InventoryServiceImpliment implements InventoryService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductFeaturesrepository featureRepository;
	@Override
	public void saveproduct(Products product) {
//		Optional<Products> prod = productRepository.findById(product.getProductId());
//		Products prod2=prod.get();
//		if(prod2.getProductDetails().getProductfeatures()!=null)
//		{
//			prod2.getProductDetails().getProductfeatures().clear();
//			productRepository.save(prod2);
//			featureRepository.deleteAll(product.getProductDetails().getProductfeatures());
//		}else {
//			productRepository.save(prod2);
//		}
		//productRepository.delete(product);
	//	System.out.println(product);
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
			throw new ProductNotFoundException("Sorry we couldn't find any matching results");
		}
		else {
		return productList;
		}
	}

	@Override
	public List<Products>getproductByPrice(Double productPrice) {
		List<Products> productList = productRepository.findByProductPrice(productPrice);
		if(productList.isEmpty()) {
			throw new ProductNotFoundException("Sorry we couldn't find any matching results ");

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
	@Override
	public ProductFeatures getProductFeatures(Integer featureId) {
		Optional<ProductFeatures> findById = featureRepository.findById(featureId);
		return findById.get();
	}
	@Override
	public void deleteProduct(Products product) {
		productRepository.delete(product);
		
	}


}
