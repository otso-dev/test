package com.smalleats.controller.partner;

import com.smalleats.service.exception.CustomException;
import com.smalleats.service.partner.PartnerFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class PartnerHomeController {
    private  final PartnerFoodService partnerFoodService;

    @RequestMapping(value = "/auth/partner", method = RequestMethod.GET)
    public String partner(){
        return "/auth/partner";
    }

    @RequestMapping(value = "/auth/partner/register", method = RequestMethod.GET)
    public String partnerRegister(){
        return "/auth/partner/register";
    }
    @RequestMapping(value = "/auth/partner/login",method = RequestMethod.GET)
    public String partnerLogin(){
        return "/auth/partner/login";
    }


    @RequestMapping(value = "/partner/partnerpage",method = RequestMethod.GET)
    public String partnerHome(){
        return"/partner/partnerpage";
    }
    @RequestMapping(value = "/partner/foodregister", method = RequestMethod.GET)
    public String foodRegister(){
        return "/partner/foodregister";
    }
    @RequestMapping(value = "/partner/menu",method = RequestMethod.GET)
    public String partnerMenu(Model model){
        if(partnerFoodService.checkPending()){
            throw new CustomException("입점신청 후 이용해주세요");
        }
       model.addAttribute("pendingFood",partnerFoodService.getPendingFood());
        return"/partner/menu";
    }
    @RequestMapping(value = "/partner/delivery",method = RequestMethod.GET)
    public String partnerDelivery(Model model){
        if(partnerFoodService.checkPending()){
            throw new CustomException("입점신청 후 이용해주세요");
        }
        model.addAttribute("pendingFood",partnerFoodService.getPendingFood());
        return"/partner/delivery";
    }
    @RequestMapping(value = "/partner/orderstate",method = RequestMethod.GET)
    public String partnerOrderState(){
        if(partnerFoodService.checkPending()){
            throw new CustomException("입점신청 후 이용해주세요");
        }
        return"/partner/orderstate";
    }


}
