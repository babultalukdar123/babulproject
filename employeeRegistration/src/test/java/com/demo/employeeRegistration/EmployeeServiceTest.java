package com.demo.employeeRegistration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.employeeRegistration.model.Employee;
import com.demo.employeeRegistration.repository.EmployeeRepository;
import com.demo.employeeRegistration.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
    EmployeeService employeeService;
	/**
	 * employee registration test
	 */
	@Test
	public void registerTest() {
		Employee employee=new Employee();
		employee.setId(1);
		employee.setFirstName("rehan");
		employee.setLastName("borah");
		employee.setDateoFBirth(new Date());
		employee.setGender("male");
		employee.setDepartment("technology");
		assertNotNull(employeeRepository);
		assertNotNull(employeeService);
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		Employee result=employeeService.register(employee);
		assertEquals(employee, result);
		
	}
	
	/**
	 * get all employee list test
	 */
	@Test
	public void getAllEmployeeTest() {
		List<Employee>employees=new ArrayList<Employee>();
		Employee employee=new Employee();
		employee.setId(1);
		employee.setFirstName("rehan");
		employee.setLastName("borah");
		employee.setDateoFBirth(new Date());
		employee.setGender("male");
		employee.setDepartment("technology");
		Employee employee1=new Employee();
		employee1.setId(2);
		employee1.setFirstName("john");
		employee1.setLastName("wick");
		employee1.setDateoFBirth(new Date());
		employee1.setGender("male");
		employee1.setDepartment("computer science");
		employees.add(employee);
		employees.add(employee1);
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);
		List<Employee>result=employeeService.getAllEmployees();
		assertEquals(employees,result);
		
	}

}
