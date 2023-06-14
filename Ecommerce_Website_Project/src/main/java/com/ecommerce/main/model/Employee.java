package com.ecommerce.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;
	private String employeeName;
	private String employeeEmail;
	@OneToOne(cascade = CascadeType.ALL)
	private Address employeeAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private User employeeUserDetails;
}
