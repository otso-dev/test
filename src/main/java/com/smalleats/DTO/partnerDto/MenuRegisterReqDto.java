package com.smalleats.DTO.partnerDto;

import com.smalleats.entity.FoodMenu;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuRegisterReqDto {
    private int foodMenuId;
    private int foodId;
    private String foodMenuName;
    private String foodMenuImg;
    private int foodMenuPrice;

    public FoodMenu toEntity(){
        return FoodMenu.builder()
                .foodId(foodId)
                .foodMenuName(foodMenuName)
                .foodMenuImg(foodMenuImg)
                .foodMenuPrice(foodMenuPrice)
                .build();
    }
}
