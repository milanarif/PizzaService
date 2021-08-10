package com.milan.pizzaservice.controllers;

import com.milan.pizzaservice.entities.Pizza;
import com.milan.pizzaservice.repositories.CustomersRepository;
import com.milan.pizzaservice.repositories.PizzasRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaController {

    private final PizzasRepository pr;

    public PizzaController(PizzasRepository pr) {
        this.pr = pr;
    }

    @GetMapping("/pizzas")
    List<Pizza> getAllPizzas() {
        return pr.findAll();
    }

    @PostMapping("/pizza")
    Pizza saveAPizza(@RequestBody Pizza pizza) {
        return pr.save(pizza);
    }
}

