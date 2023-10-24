package com.smalleats.service.partner;

import com.smalleats.DTO.partnerDto.FoodDeliveryAreaReqDto;
import com.smalleats.DTO.partnerDto.MenuRegisterReqDto;
import com.smalleats.DTO.partnerDto.PartnerPendingFoodReqDto;
import com.smalleats.DTO.partnerDto.PendingFoodRespDto;
import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.PendingFood;
import com.smalleats.repository.partner.PartnerFoodDAO;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PartnerFoodService {
    private final PartnerFoodDAO partnerFoodDAO;

    public synchronized int pendingFoodInsert(PartnerPendingFoodReqDto partnerPendingFoodReqDto){
        //synchronized 한 번에 하나의 스레드만 해당 메소드를 실행 할 수 있게 해줌 동시성 문제를 해결 할 수 있지만, 성능이 저하될 수 있음.
        //pending_food_tb에서 food_tb에서 옮길 때 기존의 pending food를 삭제할려고 했으나, 여기서 입점이 됐는지 안됐는지를 파악하는 방법을 선택
        //food_tb은 사용자가 직접 이용하는 테이블이고 pending_food_tb은 관리자와 파트너가 사용하는 테이블로 구분을 하는게 낫다고 생각하였음.
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PendingFood pendingFood = partnerFoodDAO.getPendingFood(principalUser.getPartnerId());
        if(pendingFood == null){
            throw new CustomException("입점신청을 하고 이용해주세요");
        }
        PendingFoodRespDto pendingFoodRespDto = new PendingFoodRespDto();
        return pendingFoodRespDto.toDto(pendingFood);
    }

    public boolean checkPending(){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PendingFood pendingFood = partnerFoodDAO.getPendingFood(principalUser.getPartnerId());
        return pendingFood == null;
    }
}
