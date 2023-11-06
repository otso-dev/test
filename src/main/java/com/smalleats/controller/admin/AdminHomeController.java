package com.smalleats.controller.admin;


import com.smalleats.service.UserService;
import com.smalleats.service.admin.AdminFoodManageService;
import com.smalleats.service.admin.AdminUserManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminHomeController {
    private final AdminFoodManageService adminFoodManageService;
    private final AdminUserManageService adminUserManageService;
    private final UserService userService;
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
    @RequestMapping(value = "/admin/category",method = RequestMethod.GET)
    public String adminCategory(){
        return "/admin/category";
    }
    @RequestMapping(value = "/admin/foodmanage",method = RequestMethod.GET)
    public String adminFoodManage(Model model, @RequestParam(value ="pendingStatus", required = false) String pendingStatus){
        model.addAttribute("pendingFoodList",adminFoodManageService.getPendingFoods(pendingStatus));
        return "/admin/foodmanage";
    }

    @RequestMapping(value = "/admin/usermanage", method = RequestMethod.GET)
    public String adminUserManage(Model model){
        model.addAttribute("adminUserList",adminUserManageService.adminUserSelectList());
        return "/admin/usermanage";
    }
    @RequestMapping(value = "/admin/usermanage/user/{userId}", method = RequestMethod.GET)
    public String adminUserDetail(Model model,@PathVariable int userId){
        model.addAttribute("userInfo",adminUserManageService.getUserDetail(userId));
        model.addAttribute("userAddressList",adminUserManageService.getUserAddressList(userId));
        return "/admin/user";
    }

    @RequestMapping(value = "/admin/partnermanage", method = RequestMethod.GET)
    public String adminPartnerUserManager(Model model){
        model.addAttribute("partnerUserList",adminUserManageService.adminPartnerUserSelectList());
        return "/admin/partnermanage";
    }

    @RequestMapping(value = "/admin/partnermanage/partner/{partnerId}", method = RequestMethod.GET)
    public String adminPartnerUserManager(Model model, @PathVariable int partnerId){
        model.addAttribute("partnerInfo",adminUserManageService.getPartnerUser(partnerId));
        model.addAttribute("pendingFoodInfo",adminUserManageService.getPendingFood(partnerId));
        return "/admin/partner";
    }
}
