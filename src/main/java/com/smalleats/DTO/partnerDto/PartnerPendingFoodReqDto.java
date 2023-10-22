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
public class PartnerPendingFoodReqDto {
    private int pendingFoodId;
    private int foodId;
    private int categoryId;
    private String foodName;
    private String foodImg;
    private int foodOpen;
    private int foodClose;
    private int foodMin;
    private int foodDeliveryPrice;
    private String foodAddressSido;
    private String foodRoadAddress;
    private String foodDetailAddress;
    private int foodZoneCode;

    public PendingFood toEntity(){
        return PendingFood.builder()
                .categoryId(categoryId)
                .foodName(foodName)
                .foodImg(foodImg)
                .foodOpen(foodOpen)
                .foodClose(foodClose)
                .foodMin(foodMin)
                .foodDeliveryPrice(foodDeliveryPrice)
                .foodAddressSido(foodAddressSido)
                .foodRoadAddress(foodRoadAddress)
                .foodDetailAddress(foodDetailAddress)
                .foodZoneCode(foodZoneCode)
                .build();
    }
}
