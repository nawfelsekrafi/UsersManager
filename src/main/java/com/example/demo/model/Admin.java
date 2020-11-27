package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends AppUser {
	String departement;
	
	public Admin(int id, String firstName, String grade, int salary, String login, String password,
			String departement) {
		super(id, firstName, grade, salary, login, password);
		this.departement = departement;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	
}
