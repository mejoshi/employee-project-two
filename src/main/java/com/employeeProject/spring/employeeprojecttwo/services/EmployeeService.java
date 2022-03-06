package com.employeeProject.spring.employeeprojecttwo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.employeeProject.spring.employeeprojecttwo.entity.Employee;

	
	public interface EmployeeService {
		List<Employee> getAllEmployees();
		void saveEmployee(Employee employee);
		Employee getEmployeeById(long id);
		void deleteEmployeeById(long id);
	}

