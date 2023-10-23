package com.smalleats.service.partner;

import com.smalleats.DTO.partnerDto.FoodDeliveryAreaReqDto;
import com.smalleats.DTO.partnerDto.MenuRegisterReqDto;
import com.smalleats.DTO.partnerDto.PartnerPendingFoodReqDto;
import com.smalleats.DTO.partnerDto.PendingFoodRespDto;
import com.smalleats.entity.PendingFood;
import com.smalleats.repository.partner.PartnerFoodDAO;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerFoodService {
    private final PartnerFoodDAO partnerFoodDAO;

    public int pendingFoodInsert(PartnerPendingFoodReqDto partnerPendingFoodReqDto){
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
