package com.smalleats.repository.admin;

import com.smalleats.entity.Category;
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
    public List<PendingFood> PendingFoods(String pendingStatus) {
        return sqlSession.selectList(NS + "PendingFoods", pendingStatus);
    }

    @Override
    public int adminFoodInsert(int foodId) {
        return sqlSession.insert(NS + "adminFoodInsert",foodId);
    }

    @Override
    public int adminCategory(Category category) {
        return sqlSession.insert(NS+"categoryInsert",category);
    }

}
