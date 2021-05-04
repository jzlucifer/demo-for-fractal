/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoforfractal.repository;

import com.example.demoforfractal.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose
 */

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    
}
