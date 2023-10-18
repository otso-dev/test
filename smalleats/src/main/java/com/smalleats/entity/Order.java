package com.smalleats.entity;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderId;
    private int foodId;
    private int userId;
    private String orderReqTime;
    private String orderDeliveryDay;

    private FoodProduct food;
    private User user;
}
