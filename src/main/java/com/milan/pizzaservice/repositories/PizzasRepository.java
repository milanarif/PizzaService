package com.milan.pizzaservice.repositories;

import com.milan.pizzaservice.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzasRepository extends JpaRepository<Pizza, Long> {

    List<Pizza> findAllByToppingsContains(String topping);
}
