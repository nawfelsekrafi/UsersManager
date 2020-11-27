package com.example.demo.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
@Inheritance(strategy = InheritanceType.JOINED) 
@DiscriminatorColumn(name = "grade")
@TableGenerator(name = "Vehicle_GEN",table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VALUE", allocationSize = 1)
@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String firstName;
	private String grade;
	private int salary;
	
	
	public User(int id,  String firstName, String grade, int salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.grade = grade;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
