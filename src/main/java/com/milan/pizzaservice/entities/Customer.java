package com.milan.pizzaservice.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id @GeneratedValue
    private long id;

    @OneToMany(targetEntity = Receipt.class,mappedBy = "customer")
    private List<Receipt> receipts;

    private String name;

    private String phoneNumber;
}