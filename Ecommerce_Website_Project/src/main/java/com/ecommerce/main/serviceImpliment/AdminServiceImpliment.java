package com.ecommerce.main.serviceImpliment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.exceptionHandller.EmployeeNotFoundException;
import com.ecommerce.main.model.Dealer;
import com.ecommerce.main.model.Employee;
import com.ecommerce.main.model.Products;
import com.ecommerce.main.model.UserDetails;
import com.ecommerce.main.repository.DealerRepository;
import com.ecommerce.main.repository.EmployeeRepository;
import com.ecommerce.main.repository.UserDetailsRepository;
import com.ecommerce.main.service.AdminService;
@Service
public class AdminServiceImpliment implements AdminService{
	@Autowired
	private EmployeeRepository employeeRepository;
	private DealerRepository dealerRepository;
	private UserDetailsRepository userDetailsRepository;
	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	@Override
	public void saveDealer(Dealer dealer) {
		dealerRepository.save(dealer);
		
	}
	@Override
	public List<Dealer> getAllDealer() {
			List<Dealer> getAllDealer = dealerRepository.findAll();
			
		return getAllDealer;
	}
	@Override
	public UserDetails getByUserType(String userType) {
		UserDetails findByUserType = userDetailsRepository.findByUserType(userType);
		 
		return findByUserType;
	}
	@Override
	public List<Employee> findByEmployeeName(String employeeName) {
		List<Employee> employeeList = employeeRepository.findByEmployeeName(employeeName);
		if(employeeList.isEmpty()) {
			throw new EmployeeNotFoundException("Invalid Entry");
		}
		else {
			return employeeList;
		}
		
	}

}
