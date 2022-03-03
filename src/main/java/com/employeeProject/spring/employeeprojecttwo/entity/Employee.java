package com.employeeProject.spring.employeeprojecttwo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	
	
		protected Employee() {
			
		}
	
		@Id
		@GeneratedValue
		private int id;
		private String name;
		private String designation;
		private int salary;
		private int age;
		
		public Employee(int id, String name, String designation, int salary, int age) {
			this.id = id;
			this.name = name;
			this.designation = designation;
			this.salary = salary;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getId() {
			return id;
		}
		
		
		
}
