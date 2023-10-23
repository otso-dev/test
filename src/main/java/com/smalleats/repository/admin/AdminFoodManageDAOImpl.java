package com.smalleats.repository.admin;

import com.smalleats.entity.PendingFood;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminFoodManageDAOImpl implements AdminFoodManageDAO{
    private final String NS = "com.smalleats.repository.admin.AdminFoodManageDAOImpl.";
    private final SqlSessionTemplate sqlSession;
    @Override
    public List<PendingFood> beforePendingFoods() {
        return sqlSession.selectList(NS + "beforePendingFoods");
    }

    @Override
    public int adminFoodInsert(int foodId) {
        return sqlSession.insert(NS + "adminFoodInsert",foodId);
    }
}
