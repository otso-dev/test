package com.smalleats.controller;


import com.smalleats.DTO.foodProductDTO.FoodProductsRespDto;
import com.smalleats.DTO.foodProductDTO.SearchReqDto;
import com.smalleats.entity.FoodProduct;
import com.smalleats.service.*;
import com.smalleats.service.partner.PartnerFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserAddressService userAddressService;
    private final UserService userService;
    private final FoodProductService foodProductService;
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final PartnerFoodService partnerFoodService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("productList",foodProductService.getFoodProducts());
        model.addAttribute("categoryList",partnerFoodService.getCategoryList());
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
        model.addAttribute("userAddressList",userAddressService.getUserAddressList());
        model.addAttribute("deliveryDateList", orderService.findByDeliveryDate(foodId));
        return "/product/productdetail";
    }
    @RequestMapping(value = "/payment/paymentpage/{orderId}", method = RequestMethod.GET)
    public String payment(@PathVariable int orderId, Model model){
        model.addAttribute("currentOrder", paymentService.getOrder(orderId));
        model.addAttribute("paymentMenuList",paymentService.getOrderMenuList(orderId));
        return "/payment/paymentpage";
    }

    @RequestMapping(value = "/auth/search", method = RequestMethod.POST)
    @ResponseBody
    public List<FoodProductsRespDto> search(@RequestBody SearchReqDto searchReqDto) {
        // gugun, sido, foodName, categoryName 값을 이용한 검색
        return foodProductService.foodProductSearch(searchReqDto);
    }
}
