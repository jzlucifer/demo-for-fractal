/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoforfractal.rest;

import com.example.demoforfractal.entity.Customer;
import com.example.demoforfractal.repository.CustomerRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jose
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/customer")
public class CustomerRest {
    
    @Autowired
    private CustomerRepository repository;
    
    @GetMapping("/")
    public List<Customer> readAll() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Customer readOne(@PathVariable String id) {
        return repository.findById(id).get();
    }
    
    @PostMapping("/")
    public Customer create(@RequestBody Customer customer) {
        return repository.save(customer);
    }
    
    @PutMapping("/{id}")
    public Customer update(@PathVariable String id, @RequestBody Customer customer) {
        return repository.save(customer);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
    
    @PostMapping("/testPost")
    public void testPost() {
        System.out.println("Hello World Post");
        Customer customer = new Customer();
        customer.setFirst_name("Jose");
        customer.setLast_name("Zorrilla Huerto");
        customer.setPhone_number("99998888");
        customer.setBirth_date(LocalDate.parse("1993-05-29"));
        customer.setEmail("jose@mail.com");
        repository.save(customer);
    }
}
