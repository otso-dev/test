package com.smalleats.DTO.partnerDto;

import com.smalleats.entity.Order;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderListRespDto {
    private int orderId;
    private int userId;
    private String userName;
    private String phoneNumber;
    private String foodName;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;
    private String orderReqTime;
    private String orderDeliveryDay;
    private int paymentPrice;
    private String paymentOrderState;

    private List<OrderMenuRespDto> orderMenuList;
    public OrderListRespDto toDto(Order order){
        return OrderListRespDto.builder()
                .orderId(order.getOrderId())
                .userId(order.getUserId())
                .userName(order.getUser().getUserName())
                .phoneNumber(order.getUser().getPhoneNumber())
                .foodName(order.getFood().getFoodName())
                .userRoadAddress(order.getUserAddress().getUserRoadAddress())
                .userDetailAddress(order.getUserAddress().getUserDetailAddress())
                .userZoneCode(order.getUserAddress().getUserZoneCode())
                .orderReqTime(order.getOrderReqTime())
                .orderDeliveryDay(order.getOrderDeliveryDay())
                .paymentPrice(order.getPayment().getPaymentPrice())
                .paymentOrderState(order.getPayment().getPaymentOrderState())
                .orderMenuList(new ArrayList<>())
                .build();
    }
}
