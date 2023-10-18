package com.smalleats.entity;


import com.smalleats.DTO.foodProductDTO.FoodMenuRespDto;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenu {
    private int foodMenuId;
    private int foodId;
    private String foodMenuName;
    private String foodMenuImg;
    private int foodMenuPrice;

    private FoodProduct foodProduct;
}
