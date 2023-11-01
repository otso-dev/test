package com.smalleats.DTO.adminDto;

import com.smalleats.entity.PendingFood;
import lombok.*;

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
    private String pendingStatus;

    public AdminPendingFoodRespDto toDto(PendingFood pendingFood){
        //임시로 쓰는 RespDto
        return AdminPendingFoodRespDto.builder()
                .pendingFoodId(pendingFood.getPendingFoodId())
                .foodId(pendingFood.getFoodId())
                .foodName(pendingFood.getFoodName())
                .foodAddressSido(pendingFood.getFoodAddressSido())
                .foodRoadAddress(pendingFood.getFoodRoadAddress())
                .foodDetailAddress(pendingFood.getFoodDetailAddress())
                .foodOpen(pendingFood.getFoodOpen())
                .foodClose(pendingFood.getFoodClose())
                .pendingStatus(pendingFood.getPendingStatus())
                .build();
    }
}
