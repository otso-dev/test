package com.smalleats.repository;

import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.FoodMenu;
import com.smalleats.entity.FoodProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodProductDAOImpl {
    public List<FoodProduct> getFoodProducts();

    public List<FoodMenu> getFoodMenu(int foodId);
    public List<FoodDeliveryArea> getDeliveryArea(int foodId);

    public FoodProduct getProductDetail(int foodId);
}
