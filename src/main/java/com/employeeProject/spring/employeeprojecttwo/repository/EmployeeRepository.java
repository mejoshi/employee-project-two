package com.employeeProject.spring.employeeprojecttwo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import com.employeeProject.spring.employeeprojecttwo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager entityManager;

	public List<Employee> findAll() {
		TypedQuery<Employee> namedQuery = entityManager.createNamedQuery("find_all_employees", Employee.class);
		return namedQuery.getResultList();
	}
	
	public Employee update(Employee employee){
		return entityManager.merge(employee);
	}
	
	public Employee insert(Employee employee){
		return entityManager.merge(employee);
	}
	
	public void deleteById(int id){
		Employee employee = findById(id);
		entityManager.remove(employee);
	}
	
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}


}
