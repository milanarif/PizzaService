package com.milan.pizzaservice.controllers;

import com.milan.pizzaservice.entities.*;
import com.milan.pizzaservice.repositories.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomersRepository cr;

    public CustomerController(CustomersRepository cr) {
        this.cr = cr;
    }

    @PostMapping("/customer")
    Customer saveACustomer(@RequestBody Customer customer) {
        return cr.save(customer);
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers() {
        return cr.findAll();
    }

    @GetMapping("/customer/{id}")
    Optional<Customer> getCustomer(@PathVariable("id") Long id) {
        return cr.findById(id);
    }

    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable("id") Long id) {
        cr.deleteById(id);
    }





}
