package com.smalleats.repository.partner;

import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.FoodMenu;
import com.smalleats.entity.PendingFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartnerFoodDAO {
    int pendingFoodInsert(PendingFood pendingFood);
    int foodMenuInsert(FoodMenu foodMenu);
    int foodDeliveryAreaInsert(FoodDeliveryArea foodDeliveryArea);
    List<PendingFood> pendingFoods();
    PendingFood getPendingFood(int partnerId);
}
