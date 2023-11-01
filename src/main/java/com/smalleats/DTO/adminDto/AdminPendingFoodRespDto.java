package com.smalleats.DTO.adminDto;

import com.smalleats.entity.PendingFood;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminPendingFoodRespDto {
    private int pendingFoodId;
    private int foodId;
    private String foodName;
    private String foodAddressSido;
    private String foodRoadAddress;
    private String foodDetailAddress;
    private int foodOpen;
    private int foodClose;

    public AdminPendingFoodRespDto toDto(PendingFood pendingFood){
        return AdminPendingFoodRespDto.builder()
                .pendingFoodId(pendingFood.getPendingFoodId())
                .foodId(pendingFood.getFoodId())
                .foodName(pendingFood.getFoodName())
                .foodAddressSido(pendingFood.getFoodAddressSido())
                .foodRoadAddress(pendingFood.getFoodRoadAddress())
                .foodDetailAddress(pendingFood.getFoodDetailAddress())
                .foodOpen(pendingFood.getFoodOpen())
                .foodClose(pendingFood.getFoodClose())
                .build();
    }
}
