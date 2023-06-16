package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.model.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

//	public Products findByProductCategory(String productCategory);
	public List<Products> findByProductCategory(String productCategory);
//	public List<Products> findByProductPrice(Double productPrice);
//	public List<Products> findByProductName(String productName);
}
