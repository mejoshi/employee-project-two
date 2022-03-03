package com.employeeProject.spring.employeeprojecttwo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employeeProject.spring.employeeprojecttwo.entity.Employee;
import com.employeeProject.spring.employeeprojecttwo.repository.EmployeeRepository;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/insert")
	public String addEmployee(Model model) {
		model.addAttribute("insert", new Employee());
		return "createEmployee";
	}
	
	@PostMapping("/insert")
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		model.addAttribute("insert", employee);
		return "result";
	}
	
	@GetMapping("/update")
	public String updateEmployee() {
		return "UpdateEmployee";
	}
	
	@GetMapping("/remove")
	public String removeEmployee() {
		return "DeleteEmployee";
	}
	
	@GetMapping("/display")
	public String displayEmployee(Model model) {
		model.addAttribute("insert", employeeRepository.findAll());
		return "UpdateEmployee";
	}
	
}
