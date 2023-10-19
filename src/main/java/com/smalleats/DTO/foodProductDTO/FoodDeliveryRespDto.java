package com.smalleats.DTO.foodProductDTO;


import com.smalleats.entity.FoodDeliveryArea;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDeliveryRespDto {
    private String foodDeliveryArea;

    public FoodDeliveryRespDto toEntity(FoodDeliveryArea foodDeliveryArea){
        return new FoodDeliveryRespDto(this.foodDeliveryArea = foodDeliveryArea.getFoodDeliveryArea());
    }
}
