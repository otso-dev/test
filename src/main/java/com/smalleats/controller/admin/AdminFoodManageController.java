package com.smalleats.controller.admin;


import com.smalleats.service.admin.AdminFoodManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AdminFoodManageController {
    private final AdminFoodManageService adminFoodManageService;

    @RequestMapping(value = "/admin/food/register",method = RequestMethod.POST)
    public ResponseEntity<?> adminFoodRegister(@RequestBody Map<String,Integer> foodId){
        return ResponseEntity.ok(adminFoodManageService.adminFoodRegister(foodId));
    }
}
