package com.milan.pizzaservice.controllers;

import com.milan.pizzaservice.entities.Customer;
import com.milan.pizzaservice.entities.Pizza;
import com.milan.pizzaservice.repositories.CustomersRepository;
import com.milan.pizzaservice.repositories.PizzasRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomersRepository cr;

    public CustomerController(CustomersRepository cr) {
        this.cr = cr;
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers() {
        return cr.findAll();
    }


}
