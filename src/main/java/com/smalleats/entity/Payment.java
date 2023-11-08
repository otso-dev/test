package com.smalleats.entity;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private int paymentId;
    private int orderId;
    private int foodId;
    private int paymentPrice;
    private String paymentDay;
    private String paymentOrderState;
    private int countDay;

    private Order order;
    private FoodProduct foodProduct;
}
