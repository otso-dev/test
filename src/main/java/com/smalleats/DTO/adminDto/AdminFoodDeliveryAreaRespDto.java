package com.smalleats.DTO.adminDto;

import com.smalleats.entity.FoodDeliveryArea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminFoodDeliveryAreaRespDto {
    private int foodId;
    private String foodDeliveryArea;

    public AdminFoodDeliveryAreaRespDto toDto(FoodDeliveryArea foodDeliveryArea){
        return AdminFoodDeliveryAreaRespDto.builder()
                .foodId(foodDeliveryArea.getFoodId())
                .foodDeliveryArea(foodDeliveryArea.getFoodDeliveryArea())
                .build();
    }
}
