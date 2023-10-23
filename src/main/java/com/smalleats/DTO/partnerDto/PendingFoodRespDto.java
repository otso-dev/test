package com.smalleats.DTO.partnerDto;

import com.smalleats.entity.PendingFood;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendingFoodRespDto {
    private int foodId;
    private int categoryId;
    private String foodName;
    private int foodOpen;
    private int foodClose;
    private int foodMin;
    private int foodDeliveryPrice;
    private String foodAddressSido;
    private String foodRoadAddress;
    private int foodZoneCode;

    public PendingFoodRespDto toDto(PendingFood pendingFood){
        return PendingFoodRespDto.builder()
                .foodId(pendingFood.getFoodId())
                .categoryId(pendingFood.getCategoryId())
                .foodName(pendingFood.getFoodName())
                .foodOpen(pendingFood.getFoodOpen())
                .foodClose(pendingFood.getFoodClose())
                .foodMin(pendingFood.getFoodMin())
                .foodDeliveryPrice(pendingFood.getFoodDeliveryPrice())
                .foodAddressSido(pendingFood.getFoodAddressSido())
                .foodRoadAddress(pendingFood.getFoodRoadAddress())
                .foodZoneCode(pendingFood.getFoodZoneCode())
                .build();
    }
}
