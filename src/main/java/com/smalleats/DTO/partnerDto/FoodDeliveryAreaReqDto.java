package com.smalleats.DTO.partnerDto;

import com.smalleats.entity.FoodDeliveryArea;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDeliveryAreaReqDto {
    private int foodDeliveryId;
    private int foodId;
    private String foodDeliveryArea;

    public FoodDeliveryArea toEntity(){
        return FoodDeliveryArea.builder()
                .foodId(foodId)
                .foodDeliveryArea(foodDeliveryArea)
                .build();
    }
}
