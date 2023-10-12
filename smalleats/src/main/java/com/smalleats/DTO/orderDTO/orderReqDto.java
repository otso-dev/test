package com.smalleats.DTO.orderDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class orderReqDto {
    private int userId;
    private int foodId;
    private String orderReqTime;
    private String orderReqDeliveryDay;
    private Map<String,String> orderMenu;
}
