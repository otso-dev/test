package com.smalleats.controller.partner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PartnerHomeController {

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
}
