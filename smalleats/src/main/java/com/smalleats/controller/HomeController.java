package com.smalleats.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
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
    public String mypage(){
        return "/user/mypage";
    }
}
