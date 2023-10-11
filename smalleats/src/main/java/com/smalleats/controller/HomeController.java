package com.smalleats.controller;


import com.smalleats.service.FoodProductService;
import com.smalleats.service.UserAddressService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserAddressService userAddressService;
    private final FoodProductService foodProductService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("productList",foodProductService.getFoodProducts());
        return "index";
    }

    @RequestMapping(value = "/auth/login",method = RequestMethod.GET)
    public String login(){
        return "/auth/login";
    }
    @RequestMapping(value = "/auth/register", method = RequestMethod.GET)
    public String register() {
        return "/auth/register";
    }

    @RequestMapping(value = "/admin/adminpage", method = RequestMethod.GET)
    public String admin() {return "/admin/adminpage";}

    @RequestMapping(value = "/user/mypage", method = RequestMethod.GET)
    public String mypage(Model model){
        System.out.println("page mapping");
        model.addAttribute("userAddressList",userAddressService.getUserAddressList());
        return "/user/mypage";
    }
    @RequestMapping(value = "/product/productdetail/{foodId}", method = RequestMethod.GET)
    public String productdetail(@PathVariable int foodId, Model model) {
        model.addAttribute("foodMenuList", foodProductService.getFoodMenu(foodId));
        model.addAttribute("foodDeliveryList", foodProductService.getFoodDeliverArea(foodId));
        model.addAttribute("productDetail", foodProductService.getProductDetail(foodId));

        return "/product/productdetail";
    }
}
