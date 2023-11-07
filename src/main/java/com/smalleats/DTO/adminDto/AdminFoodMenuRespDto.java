package com.smalleats.DTO.adminDto;


import com.smalleats.entity.FoodMenu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminFoodMenuRespDto {
    private int foodId;
    private String foodMenuName;
    private String foodMenuImg;
    private int foodMenuPrice;

    public AdminFoodMenuRespDto toDto(FoodMenu foodMenu){
        return AdminFoodMenuRespDto.builder()
                .foodId(foodMenu.getFoodId())
                .foodMenuName(foodMenu.getFoodMenuName())
                .foodMenuImg(foodMenu.getFoodMenuImg())
                .foodMenuPrice(foodMenu.getFoodMenuPrice())
                .build();
    }
}
