package com.milan.pizzaservice.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    @Id @GeneratedValue
    private long id;

    @ManyToMany(targetEntity = Receipt.class)
    private List<Receipt> receipts;

    private String name;

    @ElementCollection
    private List<String> toppings;

    private int price;
}
