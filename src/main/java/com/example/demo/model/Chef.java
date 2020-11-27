package com.example.demo.model;

import javax.persistence.Entity;

@Entity
public class Chef extends AppUser {
	String groupe;

	public Chef(int id, String firstName, String grade, int salary, String login, String password, String groupe) {
		super(id, firstName, grade, salary, login, password);
		this.groupe = groupe;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	
	
}
