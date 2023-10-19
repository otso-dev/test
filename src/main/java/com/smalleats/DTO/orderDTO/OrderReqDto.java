package com.smalleats.DTO.orderDTO;

import com.smalleats.entity.Order;
import lombok.*;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderReqDto {
    private int userId;
    private int foodId;
    private String orderReqTime;
    private String orderReqDeliveryDay;
    private Map<String,OrderMenuReqDto> orderMenu;

    public Order toEntity(int userId){
        return Order.builder()
                .foodId(foodId)
                .userId(userId)
                .orderReqTime(orderReqTime)
                .orderDeliveryDay(getOrderReqDeliveryDay())
                .build();
    }

    public Order toEntity(){
        return Order.builder()
                .foodId(foodId)
                .orderReqTime(orderReqTime)
                .orderDeliveryDay(getOrderReqDeliveryDay())
                .build();
    }
}
