package com.smalleats.DTO.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalleats.DTO.partnerDto.OrderMenuRespDto;
import com.smalleats.entity.Order;
import com.smalleats.entity.Payment;
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
    private int foodId;
    private int paymentPrice;
    private String paymentOrderState;
    private String paymentDay;

    private String orderReqTime;
    private String orderDeliveryDay;
    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;
    private String foodName;

    private List<OrderMenuRespDto> userOrderMenuList;

    public UserOrderListRespDto toDto(Payment payment) throws JsonProcessingException {
        String menuInfo = payment.getOrder().getOrderMenu().getMenuInfo();
        ObjectMapper objectMapper = new ObjectMapper();
        return UserOrderListRespDto.builder()
                .orderId(payment.getOrderId())
                .foodId(payment.getFoodId())
                .paymentPrice(payment.getPaymentTotalPrice())
                .paymentOrderState(payment.getPaymentOrderState())
                .paymentDay(payment.getPaymentDay())
                .orderReqTime(payment.getOrder().getOrderReqTime())
                .orderDeliveryDay(payment.getOrder().getOrderDeliveryDay())
                .userRoadAddress(payment.getOrder().getOrderRoadAddress())
                .userDetailAddress(payment.getOrder().getOrderDetailAddress())
                .userZoneCode(payment.getOrder().getOrderZoneCode())
                .foodName(payment.getFoodProduct().getFoodName())
                .userOrderMenuList(objectMapper.readValue(menuInfo, new TypeReference<List<OrderMenuRespDto>>() {
                }))
                .build();
    }
}
