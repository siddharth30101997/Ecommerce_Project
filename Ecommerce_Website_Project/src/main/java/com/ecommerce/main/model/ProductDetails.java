package com.ecommerce.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productDetailsId;
	private String productName;
	private String manufacturerName;
	private String modelNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProductFeatures> productfeatures=new ArrayList<>();
}
