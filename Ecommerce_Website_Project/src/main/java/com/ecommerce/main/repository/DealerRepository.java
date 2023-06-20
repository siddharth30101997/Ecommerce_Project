package com.ecommerce.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.model.Dealer;
@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer> {

}