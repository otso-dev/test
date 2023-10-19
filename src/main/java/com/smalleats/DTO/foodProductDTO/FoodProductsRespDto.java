package com.smalleats.DTO.foodProductDTO;

import com.smalleats.entity.FoodProduct;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodProductsRespDto {
    private int foodId;
    private String foodName;
    private String foodImg;
    private String foodOpen;
    private String foodClose;

    public FoodProductsRespDto toEntity(FoodProduct foodProduct){
        return new FoodProductsRespDto(
                this.foodId = foodProduct.getFoodId(),
                this.foodName = foodProduct.getFoodName(),
                this.foodImg = foodProduct.getFoodImg(),
                this.foodOpen = foodProduct.getFoodOpen(),
                this.foodClose = foodProduct.getFoodClose()
        );
    }
}
