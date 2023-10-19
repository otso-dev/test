package com.smalleats.DTO.foodProductDTO;

import com.smalleats.entity.FoodProduct;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodProductsRespDto {
    private int foodId;
    private String foodName;
    private String foodImg;
    private String foodOpen;
    private String foodClose;

    public FoodProductsRespDto toDto(FoodProduct foodProduct){
        return FoodProductsRespDto.builder()
                .foodId(foodProduct.getFoodId())
                .foodName(foodProduct.getFoodName())
                .foodOpen(foodProduct.getFoodOpen())
                .foodClose(foodProduct.getFoodClose())
                .foodImg(foodProduct.getFoodImg())
                .build();
    }
}
