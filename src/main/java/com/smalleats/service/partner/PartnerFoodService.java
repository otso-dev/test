package com.smalleats.service.partner;

import com.smalleats.DTO.partnerDto.*;
import com.smalleats.entity.*;
import com.smalleats.repository.partner.PartnerFoodDAO;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PartnerFoodService {
    private final PartnerFoodDAO partnerFoodDAO;

    @Transactional
    public int pendingFoodInsert(PartnerPendingFoodReqDto partnerPendingFoodReqDto){
        PrincipalUser principalUser = getPrincipalUser();
        PendingFood pendingFood = partnerFoodDAO.getPendingFood(principalUser.getPartnerId());
        if(pendingFood != null){
            throw new CustomException("입점신청은 계정 하나당 하나만 가능합니다.");
        }
        List<PendingFood> pendingFoods = partnerFoodDAO.pendingFoods();
        int foodId = 0;
        if(pendingFoods.isEmpty()){
            foodId = 1;
            return partnerFoodDAO.pendingFoodInsert(partnerPendingFoodReqDto.toEntity(foodId,principalUser.getPartnerId()));
        }
        foodId = pendingFoods.size() + 1;
        return partnerFoodDAO.pendingFoodInsert(partnerPendingFoodReqDto.toEntity(foodId,principalUser.getPartnerId()));
    }
    public int foodMenuInsert(MenuRegisterReqDto menuRegisterReqDto){
        Map<String,String> foodMenuMap = new HashMap<>();
        foodMenuMap.put("foodId",String.valueOf(menuRegisterReqDto.getFoodId()));
        foodMenuMap.put("foodMenuName", menuRegisterReqDto.getFoodMenuName());
        FoodMenu foodMenu = partnerFoodDAO.getFoodMenu(foodMenuMap);
        if(foodMenu != null){
            throw new CustomException("이미 등록된 메뉴입니다");
        }
        return partnerFoodDAO.foodMenuInsert(menuRegisterReqDto.toEntity());
    }
    public int foodDeliveryInsert(FoodDeliveryAreaReqDto foodDeliveryAreaReqDto){
        Map<String,String> map = new HashMap<>();
        map.put("foodId",String.valueOf(foodDeliveryAreaReqDto.getFoodId()));
        map.put("foodDeliveryArea",foodDeliveryAreaReqDto.getFoodDeliveryArea());
        FoodDeliveryArea foodDeliveryArea = partnerFoodDAO.getDeliveryArea(map);
        if(foodDeliveryArea != null){
            throw new CustomException("이미 등록된 배달지역입니다,");
        }
        return partnerFoodDAO.foodDeliveryAreaInsert(foodDeliveryAreaReqDto.toEntity());
    }
    public PendingFoodRespDto getPendingFood(){
        PrincipalUser principalUser = getPrincipalUser();
        PendingFood pendingFood = partnerFoodDAO.getPendingFood(principalUser.getPartnerId());
        if(pendingFood == null){
            throw new CustomException("입점신청을 하고 이용해주세요");
        }
        PendingFoodRespDto pendingFoodRespDto = new PendingFoodRespDto();
        return pendingFoodRespDto.toDto(pendingFood);
    }
    public boolean checkPending(){
        PrincipalUser principalUser = getPrincipalUser();
        PendingFood pendingFood = partnerFoodDAO.getPendingFood(principalUser.getPartnerId());
        return pendingFood == null;
    }
    public List<OrderListRespDto> orderList(){
        PrincipalUser principalUser = getPrincipalUser();
        PendingFood pendingFood = partnerFoodDAO.getPendingFood(principalUser.getPartnerId());
        OrderListRespDto orderListRespDto = new OrderListRespDto();
        List<OrderListRespDto> orderListRespDtos = new ArrayList<>();
        List<Order> orderList = partnerFoodDAO.partnerOrderList(pendingFood.getFoodId());
        orderList.forEach(order->{
            orderListRespDtos.add(orderListRespDto.toDto(order));
        });
        OrderMenuRespDto orderMenuRespDto = new OrderMenuRespDto();
        List<OrderMenuRespDto> orderMenuRespDtos = new ArrayList<>();
        List<OrderMenu> orderMenuList = partnerFoodDAO.partnerOrderMenuList(pendingFood.getFoodId());
        orderMenuList.forEach(orderMenu->{
            orderMenuRespDtos.add(orderMenuRespDto.toDto(orderMenu));
        });
        orderListRespDtos.forEach(order->{
            orderMenuRespDtos.forEach(orderMenu->{
                if(order.getOrderId() == orderMenu.getOrderId()){
                   order.getOrderMenuList().add(orderMenu);
                }
            });
        });
        return orderListRespDtos;
    }
    public int paymentOrderStateChange(PartnerOrderStateReqDto partnerOrderStateReqDto){
        if(partnerOrderStateReqDto.getPaymentOrderState().equals("배달완료")){
            throw new CustomException("이미 배달완료 상태입니다.");
        }
        Payment payment = partnerOrderStateReqDto.toEntity();
        return partnerFoodDAO.paymentOrderStateChange(payment);
    }
    private PrincipalUser getPrincipalUser(){
        return (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
