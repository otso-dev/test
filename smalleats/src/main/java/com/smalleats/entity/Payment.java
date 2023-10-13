package com.smalleats.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private int paymentId;
    private int orderId;
    private int foodId;
    private int paymentPrice;

    private Order order;
    private FoodProduct foodProduct;
}
