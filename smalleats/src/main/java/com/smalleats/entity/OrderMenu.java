package com.smalleats.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenu {
    private int orderMenuId;
    private int orderId;
    private int foodMenuId;
    private int menuNumbers;

    private Order order;
    private FoodMenu foodMenu;

}
