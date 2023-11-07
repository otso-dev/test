package com.smalleats.repository.partner;

import com.smalleats.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Mapper
public interface PartnerFoodDAO {

    int pendingFoodInsert(PendingFood pendingFood);
    int foodMenuInsert(FoodMenu foodMenu);
    int foodDeliveryAreaInsert(FoodDeliveryArea foodDeliveryArea);
    List<PendingFood> pendingFoods();
    PendingFood getPendingFood(int partnerId);
    FoodDeliveryArea getDeliveryArea(Map<String,String> deliveryMap);

    List<Payment> partnerOrderList(int foodId);
    FoodMenu getFoodMenu(Map<String,String> foodMenuMap);
    int paymentOrderStateChange(Payment payment);
    List<Category> getCategoryList();
}
