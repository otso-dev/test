package com.smalleats.entity;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodProduct {
    private int foodId;
    private String foodName;
    private String foodImg;
    private String foodOpen;
    private String foodClose;
    private String foodMin;
    private String foodDeliveryPrice;
    private String foodRoadAddress;
    private String foodDetailAddress;
    private int foodZoneCode;

    private Category category;
}
