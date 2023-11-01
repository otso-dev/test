package com.smalleats.controller;


import com.smalleats.service.FoodProductService;
import com.smalleats.service.PaymentService;
import com.smalleats.service.UserAddressService;
import com.smalleats.service.UserService;
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
    private final UserService userService;
    private final FoodProductService foodProductService;
    private final PaymentService paymentService;
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

    @RequestMapping(value = "/user/mypage", method = RequestMethod.GET)
    public String mypage(Model model){
        model.addAttribute("userAddressList",userAddressService.getUserAddressList());
        model.addAttribute("userOrderList",userService.getUserOrderList());
        return "/user/mypage";
    }
    @RequestMapping(value = "/product/productdetail/{foodId}", method = RequestMethod.GET)
    public String productdetail(@PathVariable int foodId, Model model) {
        model.addAttribute("foodMenuList", foodProductService.getFoodMenu(foodId));
        model.addAttribute("foodDeliveryList", foodProductService.getFoodDeliverArea(foodId));
        model.addAttribute("productDetail", foodProductService.getProductDetail(foodId));
        return "/product/productdetail";
    }
    @RequestMapping(value = "/payment/paymentpage/{orderId}", method = RequestMethod.GET)
    public String payment(@PathVariable int orderId, Model model){
        model.addAttribute("currentOrder", paymentService.getOrder(orderId));
        model.addAttribute("paymentMenuList",paymentService.getOrderMenuList(orderId));
        return "/payment/paymentpage";
    }
}
