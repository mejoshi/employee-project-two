package com.employeeProject.spring.employeeprojecttwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeProject.spring.employeeprojecttwo.entity.Employee;
import com.employeeProject.spring.employeeprojecttwo.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeProjectTwoApplication implements CommandLineRunner{
	@Autowired
	EmployeeRepository employeeRepository;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectTwoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Employee employee = employeeRepository.findById(102);
		
		//logger.info("Find -> {}",employeeRepository.findAll());
		employeeRepository.deleteById(105);
		logger.info("Deleted");
		logger.info("Deleted -> {}",employeeRepository.findById(103));
		logger.info("Deleted -> {}",employee.getName() + " " + employee.getSalary());



		
	}

}
