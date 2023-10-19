package com.smalleats.DTO.paymentDTO;

import com.smalleats.entity.Order;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOrderRespDto {
    private int orderId;
    private int foodId;

    private String orderReqTime;
    private String orderDeliveryDay;

    private String foodName;
    private String foodDeliveryPrice;

    public PaymentOrderRespDto toEntity(Order order){
        return new PaymentOrderRespDto(
                this.orderId = order.getOrderId(),
                this.foodId = order.getFoodId(),
                this.orderReqTime = order.getOrderReqTime(),
                this.orderDeliveryDay = order.getOrderDeliveryDay(),
                this.foodName = order.getFood().getFoodName(),
                this.foodDeliveryPrice = order.getFood().getFoodDeliveryPrice()
        );
    }
}
