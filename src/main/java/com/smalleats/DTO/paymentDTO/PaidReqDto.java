package com.smalleats.DTO.paymentDTO;

import com.smalleats.entity.Payment;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaidReqDto {
    private int orderId;
    private int foodId;
    private int paymentDeliveryPrice;
    private int paymentMenuPrice;
    private int paymentTotalPrice;

    public Payment toEntity(){
        return Payment.builder()
                .orderId(orderId)
                .foodId(foodId)
                .paymentDeliveryPrice(paymentDeliveryPrice)
                .paymentMenuTotalPrice(paymentMenuPrice)
                .paymentTotalPrice(paymentTotalPrice)
                .build();
    }
}
