package com.smalleats.DTO.paymentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paymentRespDto {
    private String orderReqTime;
    private String orderDeliveryDay;

}
