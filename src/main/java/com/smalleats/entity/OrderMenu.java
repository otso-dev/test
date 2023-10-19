package com.smalleats.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
