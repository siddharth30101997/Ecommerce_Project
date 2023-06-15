package com.ecommerce.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository <Customer , Integer> {
	

}
