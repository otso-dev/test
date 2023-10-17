package com.smalleats.DTO.paymentDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMenuRespDto {
    private int MenuNumbers;
    private int foodMenuPrice;
    private String foodMenuName;
}
