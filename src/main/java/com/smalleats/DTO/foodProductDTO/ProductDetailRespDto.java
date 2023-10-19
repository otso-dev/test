package com.smalleats.DTO.foodProductDTO;


import com.smalleats.entity.FoodProduct;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailRespDto {
    private int foodId;
    private String foodName;
    private String foodImg;
    private String foodOpen;
    private String foodClose;
    private String foodMin;
    private String foodDeliveryPrice;

    public ProductDetailRespDto toEntity(FoodProduct foodProduct){
        return new ProductDetailRespDto(
                this.foodId = foodProduct.getFoodId(),
                this.foodName = foodProduct.getFoodName(),
                this.foodImg = foodProduct.getFoodImg(),
                this.foodOpen = foodProduct.getFoodOpen(),
                this.foodClose = foodProduct.getFoodClose(),
                this.foodMin = foodProduct.getFoodMin(),
                this.foodDeliveryPrice = foodProduct.getFoodDeliveryPrice()
        );
    }
}
