package com.smalleats.DTO.foodProductDTO;


import com.smalleats.entity.FoodProduct;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailRespDto {
    private int foodId;
    private String foodName;
    private String foodImg;
    private String foodOpen;
    private String foodClose;
    private int foodMin;
    private int foodDeliveryPrice;

    public ProductDetailRespDto toDto(FoodProduct foodProduct){
        return ProductDetailRespDto.builder()
                .foodId(foodProduct.getFoodId())
                .foodImg(foodProduct.getFoodImg())
                .foodName(foodProduct.getFoodName())
                .foodOpen(foodProduct.getFoodOpen())
                .foodClose(foodProduct.getFoodClose())
                .foodMin(foodProduct.getFoodMin())
                .foodDeliveryPrice(foodProduct.getFoodDeliveryPrice())
                .build();
    }
}
