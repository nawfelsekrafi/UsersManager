package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/Employee")
@CrossOrigin(origins = "localhost:3000", maxAge = 3600)
public class EmployeeController {
	
	
			@Autowired EmployeeRepository cr;
			
			//Get all Employees
			@GetMapping("/list")
			public List<Employee> getEmployee() {
			    return (List<Employee>)cr.findAll();
			}
			// Get a Single Employee
			@GetMapping("/{id}")
			public Employee getEmployeeById(@PathVariable(value = "id") Integer EmployeeId) {
			    return cr.findById(EmployeeId)
			            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", EmployeeId));
			}
			// Post or Update the informations of an Employee
			@PostMapping("/newOrUpdate")
			public Employee createAdmin(Employee emp) {
			    return cr.save(emp);
			}
			
			// Delete an Employee
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Integer EmployeeId) {
				Employee emp = cr.findById(EmployeeId)
			            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", EmployeeId));

				cr.delete(emp);

			    return ResponseEntity.ok().build();
			}
			
			
		

	

}
