package com.smalleats.entity;

import lombok.*;

@Getter
@Builder
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
