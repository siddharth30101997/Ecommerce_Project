package com.ecommerce.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.model.ProductFeatures;
@Repository
public interface ProductFeaturesrepository extends JpaRepository<ProductFeatures, Integer>{

}
