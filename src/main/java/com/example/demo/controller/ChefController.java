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
import com.example.demo.model.Chef;
import com.example.demo.repository.ChefRepository;

@RestController
@RequestMapping("/Chef")
@CrossOrigin(origins = "localhost:3000", maxAge = 3600)
public class ChefController {
	
	
			@Autowired ChefRepository cr;
			
			//Get all Chefs
			@GetMapping("/list")
			public List<Chef> getChef() {
			    return (List<Chef>)cr.findAll();
			}
			// Get a Single Chef
			@GetMapping("/{id}")
			public Chef getChefById(@PathVariable(value = "id") Integer ChefId) {
			    return cr.findById(ChefId)
			            .orElseThrow(() -> new ResourceNotFoundException("Chef", "id", ChefId));
			}
			// Post or Update the informations of an Chef
			@PostMapping("/newOrUpdate")
			public Chef createChef(Chef chef) {
			    return cr.save(chef);
			}
			
			// Delete an Chef
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> deleteChef(@PathVariable(value = "id") Integer ChefId) {
				Chef chef = cr.findById(ChefId)
			            .orElseThrow(() -> new ResourceNotFoundException("Chef", "id", ChefId));

				cr.delete(chef);

			    return ResponseEntity.ok().build();
			}
			
			
		

	

}
