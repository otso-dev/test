package com.smalleats.entity;

import com.smalleats.DTO.foodProductDTO.FoodProductsRespDto;
import com.smalleats.DTO.foodProductDTO.ProductDetailRespDto;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodProduct {
    private int foodId;
    private String foodName;
    private String foodImg;
    private String foodOpen;
    private String foodClose;
    private String foodMin;
    private String foodDeliveryPrice;

    public FoodProductsRespDto toDto(){
        return FoodProductsRespDto.builder()
                .foodId(foodId)
                .foodName(foodName)
                .foodOpen(foodOpen)
                .foodClose(foodClose)
                .foodImg(foodImg)
                .build();
    }

    public ProductDetailRespDto toProductDetailRespDto(){
        return ProductDetailRespDto.builder()
                .foodId(foodId)
                .foodName(foodName)
                .foodImg(foodImg)
                .foodOpen(foodOpen)
                .foodClose(foodClose)
                .foodMin(foodMin)
                .foodDeliveryPrice(foodDeliveryPrice)
                .build();
    }
}
