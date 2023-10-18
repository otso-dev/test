package com.smalleats.DTO.paymentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOrderRespDto {
    private int orderId;
    private int foodId;

    private String orderReqTime;
    private String orderDeliveryDay;

    private String foodName;
    private String foodDeliveryPrice;


}
