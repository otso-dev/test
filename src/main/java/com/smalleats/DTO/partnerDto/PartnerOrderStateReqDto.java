package com.smalleats.DTO.partnerDto;


import com.smalleats.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartnerOrderStateReqDto {
    private int orderId;
    private String paymentOrderState;

    public Payment toEntity(){
        return Payment.builder()
                .orderId(orderId)
                .paymentOrderState(paymentOrderState)
                .build();
    }
}
