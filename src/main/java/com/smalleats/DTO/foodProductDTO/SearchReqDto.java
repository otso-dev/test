package com.smalleats.DTO.foodProductDTO;

import com.smalleats.entity.Category;
import com.smalleats.entity.FoodProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchReqDto {
    private String foodName;
    private String foodAddressSido;
    private String foodAddressSiGunGu;
    private String categoryName;

    public FoodProduct toEntity(){
        Category category = new Category();
        category.setCategoryName(categoryName);
        return FoodProduct.builder()
                .foodName(foodName)
                .foodAddressSido(foodAddressSido)
                .foodAddressSiGunGu(foodAddressSiGunGu)
                .category(category)
                .build();
    }
}
