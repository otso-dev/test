package com.smalleats.DTO.orderDTO;

import com.smalleats.entity.Order;
import lombok.*;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderReqDto {
    private int userId;
    private int foodId;
    private String orderReqTime;
    private String orderReqDeliveryDay;
    private String orderRoadAddress;
    private String orderDetailAddress;
    private int orderZoneCode;
    private Map<String,OrderMenuReqDto> orderMenu;

    public Order toEntity(int userId){
        return Order.builder()
                .userId(userId)
                .foodId(foodId)
                .orderReqTime(orderReqTime)
                .orderDeliveryDay(orderReqDeliveryDay)
                .orderRoadAddress(orderRoadAddress)
                .orderDetailAddress(orderDetailAddress)
                .orderZoneCode(orderZoneCode)
                .build();
    }
}
