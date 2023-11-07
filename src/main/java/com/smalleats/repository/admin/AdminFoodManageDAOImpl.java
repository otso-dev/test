package com.smalleats.repository.admin;

import com.smalleats.entity.Category;
import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.FoodMenu;
import com.smalleats.entity.PendingFood;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminFoodManageDAOImpl implements AdminFoodManageDAO{
    private final String NS = "AdminFoodManageDAOImpl.";
    private final SqlSessionTemplate sqlSession;
    @Override
    public List<PendingFood> PendingFoods(String pendingStatus) {
        return sqlSession.selectList(NS + "PendingFoods", pendingStatus);
    }

    @Override
    public int adminFoodInsert(int foodId) {
        return sqlSession.insert(NS + "adminFoodInsert",foodId);
    }

    @Override
    public int adminCategory(String category) {
        return sqlSession.insert(NS+"categoryInsert",category);
    }

    @Override
    public Category findByCategoryName(String categoryName) {
        return sqlSession.selectOne(NS+"findByCategoryName", categoryName);
    }

    @Override
    public PendingFood getPendingFoodDetail(int foodId) {
        return sqlSession.selectOne(NS + "getPendingFoodDetail",foodId);
    }

    @Override
    public List<FoodMenu> getFoodMenuList(int foodId) {
        return sqlSession.selectList(NS + "getPendingFoodMenuList", foodId);
    }

    @Override
    public List<FoodDeliveryArea> getDeliveryAreaList(int foodId) {
        return sqlSession.selectList(NS + "getFoodDeliveryAreaList", foodId);
    }

}
