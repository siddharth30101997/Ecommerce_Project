 package com.ecommerce.main.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.main.model.Dealer;
import com.ecommerce.main.model.Employee;
import com.ecommerce.main.service.AdminService;
@CrossOrigin("*")
@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired 
	private AdminService adminService;
	
	
	@PostMapping(value = "/createEmployee")
	public ResponseEntity<String> cretaeEmployee(@RequestBody Employee employee){
	
		adminService.saveEmployee(employee);
		return new ResponseEntity<String>("Employee Created",HttpStatus.CREATED); 
	}
	
	@GetMapping(value = "/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employeeList = adminService.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
		}
	
	@GetMapping(value = "getByUserType/{userType}")
	public ResponseEntity<List<Employee>> getByUserType(@PathVariable String userType){
		List<Employee> userTypeList=new ArrayList<>();
		List<Employee> employeeList = adminService.getAllEmployee();
		for (Employee employee : employeeList) {
			if(employee.getEmployeeUserDetails().getUserType().equals(userType)) {
				userTypeList.add(employee);
			}
		}
		return new ResponseEntity<List<Employee>>(userTypeList,HttpStatus.OK);
	}
	@GetMapping(value = "getByEmployeeName/{employeeName}")
	public ResponseEntity<List<Employee>> getByEmployeeName(@PathVariable String employeeName){
		List<Employee> userTypeList= adminService.findByEmployeeName(employeeName);
		
		return new ResponseEntity<List<Employee>>(userTypeList,HttpStatus.OK);
	}
	
	@PostMapping(value = "/adddealer") 
	public ResponseEntity<String>addDealer(@RequestBody Dealer dealer){
		adminService.saveDealer(dealer);
		return new ResponseEntity<String>("Dealer Added",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllDealer")
	public ResponseEntity<List<Dealer>>getAllDealer(){
		List<Dealer> getAllDealer = adminService.getAllDealer();
		
		return new ResponseEntity<List<Dealer>>(getAllDealer,HttpStatus.OK);
	}
	

}
