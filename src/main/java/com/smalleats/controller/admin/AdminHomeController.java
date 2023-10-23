package com.smalleats.controller.admin;


import com.smalleats.service.admin.AdminFoodManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class AdminHomeController {
    private final AdminFoodManageService adminFoodManageService;
    @RequestMapping(value = "/admin/adminpage",method = RequestMethod.GET)
    public String adminPage(){
        return "/admin/adminpage";
    }
    @RequestMapping(value = "/auth/admin/register",method = RequestMethod.GET)
    public String adminRegister(){
        return "/auth/admin/register";
    }
    @RequestMapping(value = "/auth/admin/login",method = RequestMethod.GET)
    public String adminLogin(){
        return "/auth/admin/login";
    }

    @RequestMapping(value = "/admin/foodmanage",method = RequestMethod.GET)
    public String adminFoodManage(Model model){
        model.addAttribute("pendingFoodList",adminFoodManageService.getPendingFoods());
        return "/admin/foodmanage";
    }
}
