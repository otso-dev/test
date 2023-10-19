package com.smalleats.DTO.paymentDTO;


import com.smalleats.entity.OrderMenu;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMenuRespDto {
    private int MenuNumbers;
    private int foodMenuPrice;
    private String foodMenuName;

    public PaymentMenuRespDto toEntity(OrderMenu orderMenu){
        return new PaymentMenuRespDto(
                this.MenuNumbers = orderMenu.getMenuNumbers(),
                this.foodMenuPrice = orderMenu.getFoodMenu().getFoodMenuPrice(),
                this.foodMenuName = orderMenu.getFoodMenu().getFoodMenuName()
        );
    }
}
