package com.smalleats.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
