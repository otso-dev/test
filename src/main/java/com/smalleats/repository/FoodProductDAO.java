package com.smalleats.repository;

import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.FoodMenu;
import com.smalleats.entity.FoodProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodProductDAO {
    List<FoodProduct> getFoodProducts();

    List<FoodMenu> getFoodMenu(int foodId);
    List<FoodDeliveryArea> getDeliveryArea(int foodId);

    FoodProduct getProductDetail(int foodId);
}
