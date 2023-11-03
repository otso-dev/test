package com.smalleats.DTO.paymentDTO;

import com.smalleats.entity.Payment;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaidReqDto {
    private int orderId;
    private int foodId;
    private int paymentPrice;

    public Payment toEntity(){
        return Payment.builder()
                .orderId(orderId)
                .paymentPrice(paymentPrice)
                .build();
    }
}
