package com.demo.employeeRegistration.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employeeRegistration.model.Employee;
import com.demo.employeeRegistration.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee register(Employee employee) {
		 Employee employe =employeeRepository.save(employee);
		 return employe;
	}
	
	
	public List<Employee> getAllEmployees(){
		List<Employee>employees= employeeRepository.findAll();
		Collections.sort(employees);
		return employees;
	}

}
