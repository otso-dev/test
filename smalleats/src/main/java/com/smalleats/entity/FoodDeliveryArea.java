package com.smalleats.entity;


import com.smalleats.DTO.foodProductDTO.FoodDeliveryRespDto;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDeliveryArea {
    private int foodDeliveryId;
    private int foodId;
    private String foodDeliveryArea;

    private FoodProduct foodProduct;

    public FoodDeliveryRespDto toDto(){
        return FoodDeliveryRespDto.builder()
                .foodDeliveryArea(foodDeliveryArea)
                .build();
    }
}
