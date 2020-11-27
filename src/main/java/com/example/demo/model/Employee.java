package com.example.demo.model;

import javax.persistence.Entity;

@Entity
public class Employee extends User {
	String description;

	
	public Employee(int id, String firstName, String grade, int salary, String description) {
		super(id, firstName, grade, salary);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
