package com.ecommerce.main.service;

import java.util.List;

import com.ecommerce.main.model.Dealer;
import com.ecommerce.main.model.Employee;
import com.ecommerce.main.model.Products;
import com.ecommerce.main.model.UserDetails;

public interface AdminService {

	public void saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public void saveDealer(Dealer dealer);

	public List<Dealer> getAllDealer();

	public UserDetails getByUserType(String userType);
	
	public List<Employee> findByEmployeeName(String employeeName);

	public Dealer getDealerById(Integer dealerId);
}
