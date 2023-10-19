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
}
