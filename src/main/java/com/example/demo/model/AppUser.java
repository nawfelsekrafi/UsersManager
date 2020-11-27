package com.example.demo.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AppUser extends  User{
	private String login;
	private String password;
	
	public AppUser(int id, String firstName, String grade, int salary, String login,
			String password) {
		super(id, firstName, grade, salary);
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
