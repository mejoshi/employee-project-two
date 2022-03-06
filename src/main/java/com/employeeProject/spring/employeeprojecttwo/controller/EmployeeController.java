package com.employeeProject.spring.employeeprojecttwo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employeeProject.spring.employeeprojecttwo.entity.Employee;
import com.employeeProject.spring.employeeprojecttwo.repository.EmployeeRepository;
import com.employeeProject.spring.employeeprojecttwo.services.EmployeeService;

@Controller
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/insert")
	public String addEmployee(Model model) {
		// create model attribute to bind form data
		model.addAttribute("employee", new Employee());
		return "createEmployee";
	}

	@PostMapping("/savedEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		System.out.println("-----------------------------------" + employee + "-------------------");
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/display")
	public String displayEmployee(Model model) {
		// create model attribute to bind form data
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addAttribute("employee", listEmployee);
		return "display";
	}
	
	@GetMapping("/remove")
	public String removeEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		return "DeleteEmployee";
	}

	@RequestMapping(value="/deletedEmployee", method = RequestMethod.POST)
	public String removeEmployee(@ModelAttribute("employee") Employee employee){
		// remove employee to database
		List<Employee> listEmployees = employeeService.getAllEmployees();
		System.out.println("-----------------------------------" + employee + "-------------------");
		for(Employee employee2 : listEmployees) {
			System.out.println(employee2.getName());
				if(employee2.getName().equals(employee.getName())) {
					employeeService.deleteEmployeeById(employee2.getId());
				}
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		return "UpdateEmployee";
	}
	
	@RequestMapping(value="/updatedEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee){
		// remove employee to database
		List<Employee> listEmployees = employeeService.getAllEmployees();
		System.out.println("-----------------------------------" + employee + "-------------------");
		Employee emp = null;
		for(Employee employee2 : listEmployees) {
			System.out.println(employee2.getName());
				if(employee2.getName().equals(employee.getName())) {
					emp = employeeService.getEmployeeById(employee2.getId());
				}
		}
		System.out.println("----------------------" + emp + "---------------------------");
		System.out.println("----------------------" + emp.getId() + "---------------------------");

		employeeService.saveEmployee(emp);
		
		return "redirect:/";
	}

}
