package com.smalleats.repository.admin;

import com.smalleats.entity.Category;
import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.FoodMenu;
import com.smalleats.entity.PendingFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminFoodManageDAO {
    List<PendingFood> PendingFoods(String pendingStatus);

    int adminFoodInsert(int foodId);

    int adminCategory(String category);

    Category findByCategoryName(String categoryName);

    PendingFood getPendingFoodDetail(int foodId);
    List<FoodMenu> getFoodMenuList(int foodId);
    List<FoodDeliveryArea> getDeliveryAreaList(int foodId);

}
