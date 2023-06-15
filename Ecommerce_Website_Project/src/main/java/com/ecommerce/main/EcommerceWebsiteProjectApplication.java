package com.ecommerce.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

import com.ecommerce.main.model.Products;

@SpringBootApplication
public class EcommerceWebsiteProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceWebsiteProjectApplication.class, args);
		
	}

}
