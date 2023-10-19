package com.smalleats.DTO.foodProductDTO;


import com.smalleats.entity.FoodDeliveryArea;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDeliveryRespDto {
    private String foodDeliveryArea;

    public FoodDeliveryRespDto toDto(FoodDeliveryArea foodDeliveryArea){
        return FoodDeliveryRespDto.builder()
                .foodDeliveryArea(foodDeliveryArea.getFoodDeliveryArea())
                .build();
    }
}
