package com.smalleats.entity;


import com.smalleats.DTO.paymentDTO.PaymentOrderRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderId;
    private int foodId;
    private int userId;
    private String orderReqTime;
    private String orderDeliveryDay;

    private FoodProduct food;
    private User user;

    public PaymentOrderRespDto toPaymentOrder(){
        return PaymentOrderRespDto.builder()
                .orderId(orderId)
                .foodId(foodId)
                .orderDeliveryDay(orderDeliveryDay)
                .orderReqTime(orderReqTime)
                .foodName(food.getFoodName())
                .foodDeliveryPrice(food.getFoodDeliveryPrice())
                .build();
    }
}
