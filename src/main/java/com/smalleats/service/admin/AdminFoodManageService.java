package com.smalleats.service.admin;

import com.smalleats.DTO.adminDto.AdminPendingFoodRespDto;
import com.smalleats.entity.Category;
import com.smalleats.entity.PendingFood;
import com.smalleats.repository.admin.AdminFoodManageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminFoodManageService {
    private final AdminFoodManageDAO adminFoodManageDAO;

    public List<AdminPendingFoodRespDto> getPendingFoods(){
        AdminPendingFoodRespDto adminPendingFoodRespDto = new AdminPendingFoodRespDto();
        List<AdminPendingFoodRespDto> adminPendingFoodRespDtos = new ArrayList<>();
        List<PendingFood> pendingFoods = adminFoodManageDAO.beforePendingFoods();
        pendingFoods.forEach(pendingFood -> {
            adminPendingFoodRespDtos.add(adminPendingFoodRespDto.toDto(pendingFood));
        });
        return adminPendingFoodRespDtos;
    }
    public int adminFoodRegister(Map<String,Integer> foodId){
        return adminFoodManageDAO.adminFoodInsert(foodId.get("foodId"));
    }
    public int adminCategoryInsert(String categoryName){
        Category category = new Category(0,categoryName);
        return adminFoodManageDAO.adminCategory(category);
    }
}
