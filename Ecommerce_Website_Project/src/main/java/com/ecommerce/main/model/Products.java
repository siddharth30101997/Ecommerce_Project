package com.ecommerce.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productCategory;
	private Double productPrice;
	private Integer productAvailableCount;
	private Integer productRating;
	private String productStatus;
	private byte[] productPhoto;
	private Boolean isActive;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProductDetails productDetails;
	 
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Dealer> availableDealers=new ArrayList<>();
}
