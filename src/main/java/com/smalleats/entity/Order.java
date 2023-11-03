package com.smalleats.entity;


import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String orderRoadAddress;
    private String orderDetailAddress;
    private int orderZoneCode;

    private User user;
    private FoodProduct foodProduct;
}
