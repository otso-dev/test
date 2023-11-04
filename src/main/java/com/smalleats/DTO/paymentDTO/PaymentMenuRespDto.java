package com.smalleats.DTO.paymentDTO;


import com.smalleats.entity.OrderMenu;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMenuRespDto {
    private String menuInfo;

    public PaymentMenuRespDto toDto(OrderMenu orderMenu){
        return PaymentMenuRespDto.builder()
                .menuInfo(orderMenu.getMenuInfo())
                .build();
    }
}
