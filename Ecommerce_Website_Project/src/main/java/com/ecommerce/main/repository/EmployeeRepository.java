package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.main.model.Employee;
import com.ecommerce.main.model.Products;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	public  List<Employee> findByEmployeeName(String employeeName);
	

}
