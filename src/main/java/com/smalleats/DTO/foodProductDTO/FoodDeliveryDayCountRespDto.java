package com.smalleats.DTO.foodProductDTO;


import com.smalleats.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDeliveryDayCountRespDto {
    private String foodName;
    private String orderDeliveryDay;
    private int countDay;

    public FoodDeliveryDayCountRespDto toDto(Payment payment){
        return FoodDeliveryDayCountRespDto.builder()
                .foodName(payment.getFoodProduct().getFoodName())
                .orderDeliveryDay(payment.getOrder().getOrderDeliveryDay())
                .countDay(payment.getCountDay())
                .build();
    }
}
