package com.ecommerce.main.serviceImpliment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.model.Customer;
import com.ecommerce.main.repository.CustomerRepository;
import com.ecommerce.main.service.CustomerService;
@Service
public class CustomerServiceImplement implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void savecustomer(Customer customer) {
		customerRepository.save(customer);
	}

}
