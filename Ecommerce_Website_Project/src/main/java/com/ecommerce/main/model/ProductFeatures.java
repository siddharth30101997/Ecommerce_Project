package com.ecommerce.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeatures {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productFeatureId;
	private String productFeatureName;
	private String productFeatureValue;
}
