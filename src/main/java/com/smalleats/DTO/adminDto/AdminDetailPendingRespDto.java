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
public class AdminDetailPendingRespDto {
    private int pendingFoodId;
    private int foodId;
    private String foodName;
    private String foodAddressSido;
    private String foodRoadAddress;
    private String foodDetailAddress;
    private int foodZoneCode;
    private int foodOpen;
    private int foodClose;
    private int foodMin;
    private int foodDeliveryPrice;
    private String pendingStatus;
    private String categoryName;
    private String partnerUserName;
    private String partnerPhoneNumber;

    public AdminDetailPendingRespDto toDto(PendingFood pendingFood){
        return AdminDetailPendingRespDto.builder()
                .pendingFoodId(pendingFood.getPendingFoodId())
                .foodId(pendingFood.getFoodId())
                .foodName(pendingFood.getFoodName())
                .foodAddressSido(pendingFood.getFoodAddressSido())
                .foodRoadAddress(pendingFood.getFoodRoadAddress())
                .foodDetailAddress(pendingFood.getFoodDetailAddress())
                .foodZoneCode(pendingFood.getFoodZoneCode())
                .foodOpen(pendingFood.getFoodOpen())
                .foodClose(pendingFood.getFoodClose())
                .foodMin(pendingFood.getFoodMin())
                .foodDeliveryPrice(pendingFood.getFoodDeliveryPrice())
                .pendingStatus(pendingFood.getPendingStatus())
                .categoryName(pendingFood.getCategory().getCategoryName())
                .partnerUserName(pendingFood.getPartnerUser().getPartnerUserName())
                .partnerPhoneNumber(pendingFood.getPartnerUser().getPartnerPhoneNumber())
                .build();
    }
}
