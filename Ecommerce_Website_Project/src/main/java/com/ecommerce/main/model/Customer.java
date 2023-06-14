package com.ecommerce.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private Long customerMobileNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserDetails customerUserDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address customerAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails customerBankDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Products> wishList=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderDetails> orderHistory=new ArrayList<>();


}