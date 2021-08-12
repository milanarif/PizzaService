package com.milan.pizzaservice.controllers;

import com.milan.pizzaservice.entities.Pizza;
import org.modelmapper.*;
import com.milan.pizzaservice.dtos.PizzaDto;
import com.milan.pizzaservice.repositories.PizzasRepository;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RestController
public class PizzaController {

    private final PizzasRepository pizzasRepository;
    private final ModelMapper modelMapper;


    public PizzaController(PizzasRepository pr, ModelMapper modelMapper) {
        this.pizzasRepository = pr;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/pizzas")
    List<PizzaDto> getAllPizzas() {
    Type listType = new TypeToken<List<PizzaDto>>(){}.getType();
    return modelMapper.map(pizzasRepository.findAll(), listType);
    }

    //TODO: SHOULD RETURN NULL OR EMPTY DTO?
    @GetMapping("pizza/{id}")
    PizzaDto getPizza(@PathVariable("id") long id) {
        if (pizzasRepository.existsById(id)) {
            return modelMapper.map(pizzasRepository.getById(id), PizzaDto.class);
        }
        else return null;
    }

    @PostMapping("/pizza")
    PizzaDto saveAPizza(@RequestBody PizzaDto pizza) {
        Pizza pizzaToSave = modelMapper.map(pizza, Pizza.class);
        pizzasRepository.save(pizzaToSave);
        return pizza;
    }

    @DeleteMapping("/pizza/{id}")
    PizzaDto removePizza(@PathVariable("id") long id) {
        Optional<Pizza> pizza = pizzasRepository.findById(id);
        if (pizza.isPresent()) {
            PizzaDto pizzaDto = modelMapper.map(pizza, PizzaDto.class);
            pizzasRepository.deleteById(id);
            return pizzaDto;
        }
        else return null;
    }

   /*

   @PatchMapping("pizza/{id}")
    PizzaDto patch(@PathVariable("id") Long id) {
        if (pizzasRepository.existsById(id)) {
            pizzasRepository.
        }
        return modelMapper.map(pizzasRepository.)
    }



    @PutMapping

    */



}

