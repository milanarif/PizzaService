package com.milan.pizzaservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    @Id @GeneratedValue
    private long id;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    @ManyToMany(targetEntity = Pizza.class,mappedBy = "receipts")
    private List<Pizza> pizzas;
}
