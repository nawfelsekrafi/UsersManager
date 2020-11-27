package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Work;

public interface WorkRepository extends CrudRepository<Work, Integer> {

}
