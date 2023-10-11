package com.smalleats.DTO.foodProductDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailRespDto {
    private String foodName;
    private String foodImg;
    private String foodOpen;
    private String foodClose;
    private String foodMin;
    private String foodDeliveryPrice;
}
