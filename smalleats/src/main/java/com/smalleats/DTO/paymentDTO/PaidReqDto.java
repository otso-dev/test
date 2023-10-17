package com.smalleats.DTO.paymentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaidReqDto {
    private int orderId;
    private int foodId;
    private int paymentPrice;
}
