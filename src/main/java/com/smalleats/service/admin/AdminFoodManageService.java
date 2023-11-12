package com.smalleats.service.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smalleats.DTO.adminDto.AdminDetailPendingRespDto;
import com.smalleats.DTO.adminDto.AdminFoodDeliveryAreaRespDto;
import com.smalleats.DTO.adminDto.AdminFoodMenuRespDto;
import com.smalleats.DTO.adminDto.AdminPendingFoodRespDto;
import com.smalleats.DTO.partnerDto.OrderListRespDto;
import com.smalleats.entity.*;
import com.smalleats.repository.OrderDAO;
import com.smalleats.repository.admin.AdminFoodManageDAO;
import com.smalleats.repository.partner.PartnerFoodDAO;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminFoodManageService {
    private final AdminFoodManageDAO adminFoodManageDAO;
    private final PartnerFoodDAO partnerFoodDAO;

    public List<AdminPendingFoodRespDto> getPendingFoods(String pendingStatus){
        AdminPendingFoodRespDto adminPendingFoodRespDto = new AdminPendingFoodRespDto();
        List<AdminPendingFoodRespDto> adminPendingFoodRespDtos = new ArrayList<>();
        List<PendingFood> pendingFoods = adminFoodManageDAO.PendingFoods(pendingStatus);
        pendingFoods.forEach(pendingFood -> {
            adminPendingFoodRespDtos.add(adminPendingFoodRespDto.toDto(pendingFood));
        });
        return adminPendingFoodRespDtos;
    }

    @Transactional
    public int adminFoodRegister(Map<String,Integer> foodId){
        int result = adminFoodManageDAO.adminFoodInsert(foodId.get("foodId"));
        if(result <= 0){
            throw new CustomException("등록실패");
        }
        return adminFoodManageDAO.pendingStatusUpdate(foodId.get("foodId"));
    }
    public int adminCategoryInsert(String categoryName){
        Category category = adminFoodManageDAO.findByCategoryName(categoryName);
        if(category != null){
            throw new CustomException("이미 등록된 카테고리 입니다.");
        }
        return adminFoodManageDAO.adminCategory(categoryName);
    }

    public AdminDetailPendingRespDto getPendingFoodDetail(int foodId){
        PendingFood pendingFood = adminFoodManageDAO.getPendingFoodDetail(foodId);
        AdminDetailPendingRespDto adminPendingFoodRespDto = new AdminDetailPendingRespDto();
        return adminPendingFoodRespDto.toDto(pendingFood);
    }

    public List<AdminFoodMenuRespDto> getFoodMenuList(int foodId){
        AdminFoodMenuRespDto adminFoodMenuRespDto = new AdminFoodMenuRespDto();

        List<FoodMenu> foodMenuList = adminFoodManageDAO.getFoodMenuList(foodId);
        List<AdminFoodMenuRespDto> foodMenuRespDtoList = new ArrayList<>();

        foodMenuList.forEach(foodMenu -> {
            foodMenuRespDtoList.add(adminFoodMenuRespDto.toDto(foodMenu));
        });

        return foodMenuRespDtoList;
    }

    public List<AdminFoodDeliveryAreaRespDto> getDeliveryAreaList(int foodId){
        AdminFoodDeliveryAreaRespDto adminFoodDeliveryAreaRespDto = new AdminFoodDeliveryAreaRespDto();

        List<FoodDeliveryArea> foodDeliveryAreaList = adminFoodManageDAO.getDeliveryAreaList(foodId);
        List<AdminFoodDeliveryAreaRespDto> adminFoodDeliveryAreaRespDtoList = new ArrayList<>();

        foodDeliveryAreaList.forEach(foodDeliveryArea -> {
            adminFoodDeliveryAreaRespDtoList.add(adminFoodDeliveryAreaRespDto.toDto(foodDeliveryArea));
        });
        return adminFoodDeliveryAreaRespDtoList;
    }

    public List<OrderListRespDto> getFoodOrderList(int foodId){
        OrderListRespDto orderListRespDto = new OrderListRespDto();

        List<OrderListRespDto> orderListRespDtoList = new ArrayList<>();
        List<Payment> orderList = partnerFoodDAO.partnerOrderList(foodId);
        
        orderList.forEach(payment->{
            try {
                orderListRespDtoList.add(orderListRespDto.toDto(payment));
            } catch (Exception e) {
                throw new CustomException("JSON 파싱 실패");
            }
        });
        return orderListRespDtoList;
    }
}
