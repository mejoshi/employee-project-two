package com.employeeProject.spring.employeeprojecttwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.employeeProject.spring.employeeprojecttwo.entity.Employee;
import com.employeeProject.spring.employeeprojecttwo.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeProjectTwoApplication{
	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectTwoApplication.class, args);
	}
}
