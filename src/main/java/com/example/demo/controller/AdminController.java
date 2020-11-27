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
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "localhost:3000", maxAge = 3600)
public class AdminController {
		@Autowired AdminRepository cr;
		
		//Get all Admins
		@GetMapping("/list")
		public List<Admin> getAdmin() {
		    return (List<Admin>)cr.findAll();
		}
		// Get a Single Admin
		@GetMapping("/{id}")
		public Admin getAdminById(@PathVariable(value = "id") Integer AdminId) {
		    return cr.findById(AdminId)
		            .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", AdminId));
		}
		// Post or Update the informations of an Admin
		@PostMapping("/newOrUpdate")
		public Admin createAdmin(Admin admin) {
		    return cr.save(admin);
		}
		
		// Delete an Admin
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Integer AdminId) {
			Admin admin = cr.findById(AdminId)
		            .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", AdminId));

			cr.delete(admin);

		    return ResponseEntity.ok().build();
		}
		
		
	

}
