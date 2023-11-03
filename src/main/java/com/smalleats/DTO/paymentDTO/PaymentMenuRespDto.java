package com.smalleats.DTO.paymentDTO;


import com.smalleats.entity.OrderMenu;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMenuRespDto {
    private int MenuNumbers;
    private int foodMenuPrice;
    private String foodMenuName;

    public PaymentMenuRespDto toDto(OrderMenu orderMenu){
        return PaymentMenuRespDto.builder()
                .foodMenuPrice(orderMenu.getFoodMenu().getFoodMenuPrice())
                .foodMenuName(orderMenu.getFoodMenu().getFoodMenuName())
                .build();
    }
}
