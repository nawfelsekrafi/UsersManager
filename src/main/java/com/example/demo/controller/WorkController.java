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
import com.example.demo.model.Work;
import com.example.demo.repository.WorkRepository;

@RestController
@RequestMapping("/Work")
@CrossOrigin(origins = "localhost:3000", maxAge = 3600)
public class WorkController {
	
	
			@Autowired WorkRepository cr;
			
			//Get all Works
			@GetMapping("/list")
			public List<Work> getAdmin() {
			    return (List<Work>)cr.findAll();
			}
			// Get a Single Work
			@GetMapping("/{id}")
			public Work getWorkById(@PathVariable(value = "id") Integer WorkId) {
			    return cr.findById(WorkId)
			            .orElseThrow(() -> new ResourceNotFoundException("Work", "id", WorkId));
			}
			// Post or Update the informations of an Work
			@PostMapping("/newOrUpdate")
			public Work createWork(Work work) {
			    return cr.save(work);
			}
			
			// Delete an Work
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<?> deleteWork(@PathVariable(value = "id") Integer WorkId) {
				Work work = cr.findById(WorkId)
			            .orElseThrow(() -> new ResourceNotFoundException("Work", "id", WorkId));

				cr.delete(work);

			    return ResponseEntity.ok().build();
			}
			
			
		

	

}
