package com.smalleats.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendingFood {
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

    private Category category;
}
