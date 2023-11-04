package com.smalleats.DTO.partnerDto;

import com.smalleats.entity.OrderMenu;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderMenuRespDto {
    private int userId;
    private int orderId;
    private int menuNumbers;
    private String foodMenuName;
    private int foodMenuPrice;

    public OrderMenuRespDto toDto(OrderMenu orderMenu){
        return OrderMenuRespDto.builder()
                .userId(userId)
                .build();
    }
}
