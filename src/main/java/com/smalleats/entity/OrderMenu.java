package com.smalleats.entity;

import lombok.*;
import org.json.simple.JSONObject;


@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenu {
    private int orderId;
    private String menuInfo;

    private Order order;
    private FoodMenu foodMenu;
    private User user;
}
