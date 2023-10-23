package com.smalleats.controller.partner;

import com.smalleats.DTO.partnerDto.FoodDeliveryAreaReqDto;
import com.smalleats.DTO.partnerDto.MenuRegisterReqDto;
import com.smalleats.DTO.partnerDto.PartnerPendingFoodReqDto;
import com.smalleats.service.partner.PartnerFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class PartnerFoodController {
    private final PartnerFoodService partnerFoodService;
    @RequestMapping(value = "/partner/foodregister",method = RequestMethod.POST)
    public ResponseEntity<?> pendingFoodInsert(@RequestBody PartnerPendingFoodReqDto partnerPendingFoodReqDto){
        return ResponseEntity.ok(partnerFoodService.pendingFoodInsert(partnerPendingFoodReqDto));
    }

    @RequestMapping(value = "/partner/menu", method = RequestMethod.POST)
    public ResponseEntity<?> foodMenuInsert(@RequestBody MenuRegisterReqDto menuRegisterReqDto){
        return ResponseEntity.ok(partnerFoodService.foodMenuInsert(menuRegisterReqDto));
    }

    @RequestMapping(value = "/partner/delivery",method = RequestMethod.POST)
    public ResponseEntity<?> foodDeliveryInsert(@RequestBody FoodDeliveryAreaReqDto foodDeliveryAreaReqDto){
        return ResponseEntity.ok(partnerFoodService.foodDeliveryInsert(foodDeliveryAreaReqDto));
    }
}
