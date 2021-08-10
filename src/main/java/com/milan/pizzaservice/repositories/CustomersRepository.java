package com.milan.pizzaservice.repositories;

import com.milan.pizzaservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByName(String name);
}
