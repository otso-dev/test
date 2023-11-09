package com.smalleats.DTO.partnerDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalleats.entity.Order;
import com.smalleats.entity.Payment;
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

    private int paymentPrice;
    private String paymentOrderState;
    private String paymentDay;

    private String userName;
    private String phoneNumber;

    private String userRoadAddress;
    private String userDetailAddress;
    private int userZoneCode;
    private String orderReqTime;
    private String orderDeliveryDay;

    private List<OrderMenuRespDto> orderMenuList;
    public OrderListRespDto toDto(Payment payment) throws JsonProcessingException {
        String menuInfo = payment.getOrder().getOrderMenu().getMenuInfo();
        ObjectMapper objectMapper = new ObjectMapper();
        return OrderListRespDto.builder()
                .orderId(payment.getOrderId())
                .userId(payment.getOrder().getUserId())
                .paymentOrderState(payment.getPaymentOrderState())
                .paymentPrice(payment.getPaymentTotalPrice())
                .paymentDay(payment.getPaymentDay())
                .userName(payment.getOrder().getUser().getUserName())
                .phoneNumber(payment.getOrder().getUser().getPhoneNumber())
                .userRoadAddress(payment.getOrder().getOrderRoadAddress())
                .userDetailAddress(payment.getOrder().getOrderDetailAddress())
                .userZoneCode(payment.getOrder().getOrderZoneCode())
                .orderReqTime(payment.getOrder().getOrderReqTime())
                .orderDeliveryDay(payment.getOrder().getOrderDeliveryDay())
                .orderMenuList(objectMapper.readValue(menuInfo, new TypeReference<List<OrderMenuRespDto>>() {
                }))
                .build();
    }
}
