package com.smalleats.entity;


import com.smalleats.DTO.foodProductDTO.FoodDeliveryRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
