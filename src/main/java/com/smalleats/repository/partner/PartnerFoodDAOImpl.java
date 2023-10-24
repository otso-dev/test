package com.smalleats.repository.partner;

import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.FoodMenu;
import com.smalleats.entity.PendingFood;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PartnerFoodDAOImpl implements PartnerFoodDAO {
    private final String NS = "com.smalleats.repository.partner.PartnerFoodDAOImpl.";
    private final SqlSessionTemplate sqlSession;


    @Override
    public int pendingFoodInsert(PendingFood pendingFood) {
        return sqlSession.insert(NS + "pendingFoodInsert", pendingFood);
    }

    @Override
    public int foodMenuInsert(FoodMenu foodMenu) {
        return sqlSession.insert(NS + "foodMenuInsert", foodMenu);
    }

    @Override
    public int foodDeliveryAreaInsert(FoodDeliveryArea foodDeliveryArea) {
        return sqlSession.insert(NS + "foodDeliveryAreaInsert", foodDeliveryArea);
    }

    @Override
    public List<PendingFood> pendingFoods() {
        return sqlSession.selectList(NS+"pendingFoods");
    }

    @Override
    public PendingFood getPendingFood(int partnerId) {
        return sqlSession.selectOne(NS+"getPendingFood",partnerId);
    }

    @Override
    public FoodDeliveryArea getDeliveryArea(Map<String, String> deliveryMap) {
        return sqlSession.selectOne(NS+"duplicatedArea", deliveryMap);
    }
}
