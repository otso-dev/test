package com.smalleats.entity;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDeliveryArea {
    private int foodDeliveryId;
    private int foodId;
    private String foodDeliveryArea;

    private FoodProduct foodProduct;

}
