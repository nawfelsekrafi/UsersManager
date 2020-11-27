/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.User;
import javax.persistence.Id;
import org.springframework.data.repository.CrudRepository;

/**
 *

 */
public interface UserRepository extends CrudRepository<User,Integer> {
    
}
