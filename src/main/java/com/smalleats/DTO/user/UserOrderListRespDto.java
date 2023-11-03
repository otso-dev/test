package com.smalleats.DTO.user;

import com.smalleats.DTO.partnerDto.OrderMenuRespDto;
import com.smalleats.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderListRespDto {
    private int orderId;
    private String foodName;
    private String orderReqTime;
    private String orderDeliveryDay;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;
    private int paymentPrice;
    private String paymentOrderState;

    private List<OrderMenuRespDto> userOrderMenuList;

    public UserOrderListRespDto toDto(Order order){
        return UserOrderListRespDto.builder()
                .orderId(order.getOrderId())
                .build();
    }
}
