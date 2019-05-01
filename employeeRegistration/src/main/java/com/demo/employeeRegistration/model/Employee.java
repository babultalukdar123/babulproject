package com.demo.employeeRegistration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Employee implements Comparable<Employee>{
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String firstName;
	private String lastName;
	@NotNull
	private String gender;
	@Past
	private Date dateoFBirth;
	@NotNull
	private String department;
	
	public Employee() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateoFBirth() {
		return dateoFBirth;
	}
	public void setDateoFBirth(Date dateoFBirth) {
		this.dateoFBirth = dateoFBirth;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public int compareTo(Employee object) {
        
		return this.getFirstName().compareTo(object.getFirstName());
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dateoFBirth=" + dateoFBirth + ", department=" + department + "]";
	}

	

}
