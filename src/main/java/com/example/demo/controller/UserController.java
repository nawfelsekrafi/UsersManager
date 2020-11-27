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
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "localhost:3000", maxAge = 3600)
public class UserController {
	
			@Autowired UserRepository cr;
			
			//Get all Users
			@GetMapping("/list")
			public List<User> getAdmin() {
			    return (List<User>)cr.findAll();
			}
			// Get a Single User
			@GetMapping("/{id}")
			public User getUserById(@PathVariable(value = "id") Integer UserId) {
			    return cr.findById(UserId)
			            .orElseThrow(() -> new ResourceNotFoundException("User", "id",UserId));
			}
			// Post or Update the informations of an User
			@PostMapping("/newOrUpdate")
			public User createUser(User user) {
			    return cr.save(user);
			}
			
			// Delete an User
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer UserId) {
				User user = cr.findById(UserId)
			            .orElseThrow(() -> new ResourceNotFoundException("User", "id", UserId));

				cr.delete(user);

			    return ResponseEntity.ok().build();
			}
			
			
		

	

}
