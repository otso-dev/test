package com.smalleats.DTO.foodProductDTO;


import com.smalleats.entity.FoodMenu;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenuRespDto {
    private int foodMenuId;
    private int foodMenuPrice;
    private String foodMenuName;
    private String foodMenuImg;

    public FoodMenuRespDto toDto(FoodMenu foodMenu){
        return new FoodMenuRespDto(
               this.foodMenuId = foodMenu.getFoodMenuId(),
               this.foodMenuPrice = foodMenu.getFoodMenuPrice(),
               this.foodMenuName = foodMenu.getFoodMenuName(),
               this.foodMenuImg = foodMenu.getFoodMenuImg()
       );
    }
}
