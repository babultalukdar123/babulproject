package com.demo.employeeRegistration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeeRegistration.model.Employee;
import com.demo.employeeRegistration.service.EmployeeService;

@RestController
@RequestMapping("/rest/api")
public class RegistrationController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/registerEmployee")
	public Employee registerEmployee(@Valid @RequestBody Employee employee) {
		Employee employeeReg=employeeService.register(employee);
		return employeeReg;
	}
	
	@GetMapping("/employees")
	public List<Employee>getAllEmployee(){
		return employeeService.getAllEmployees();
	}

}
