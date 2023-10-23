package com.smalleats.repository.admin;

import com.smalleats.entity.PendingFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminFoodManageDAO {
    List<PendingFood> beforePendingFoods();

    int adminFoodInsert(int foodId);
}
