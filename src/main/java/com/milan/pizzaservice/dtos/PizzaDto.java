package com.milan.pizzaservice.dtos;

import com.milan.pizzaservice.entities.Receipt;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PizzaDto {
    long id;
    String name;
    List<String> toppings;
    int price;
    List<Receipt> receipts;
}
