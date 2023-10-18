package com.smalleats.entity;


import com.smalleats.DTO.paymentDTO.PaymentMenuRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenu {
    private int orderMenuId;
    private int orderId;
    private int foodMenuId;
    private int menuNumbers;

    private Order order;
    private FoodMenu foodMenu;

    public PaymentMenuRespDto toPaymentMenu(){
        return PaymentMenuRespDto.builder()
                .MenuNumbers(menuNumbers)
                .foodMenuPrice(foodMenu.getFoodMenuPrice())
                .foodMenuName(foodMenu.getFoodMenuName())
                .build();
    }

}
