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
public class BankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bankAccountNumber;
	private String bankName;
	private String branchName;
	private String ifscNumber;
	private Long cardNumber;
	
}
