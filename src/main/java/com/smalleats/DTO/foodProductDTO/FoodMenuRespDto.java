package com.smalleats.DTO.foodProductDTO;


import com.smalleats.entity.FoodMenu;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenuRespDto {
    private int foodMenuId;
    private int foodMenuPrice;
    private String foodMenuName;
    private String foodMenuImg;

    public FoodMenuRespDto toDto(FoodMenu foodMenu){
        return FoodMenuRespDto
                .builder()
                .foodMenuId(foodMenu.getFoodMenuId())
                .foodMenuPrice(foodMenu.getFoodMenuPrice())
                .foodMenuName(foodMenu.getFoodMenuName())
                .foodMenuImg(foodMenu.getFoodMenuImg())
                .build();
    }
}
