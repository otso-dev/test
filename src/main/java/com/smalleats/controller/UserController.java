package com.smalleats.controller;

import com.smalleats.DTO.user.LoginReqDto;
import com.smalleats.DTO.user.PasswordReqDto;
import com.smalleats.DTO.user.SignupReqDto;
import com.smalleats.DTO.user.UserAddressReqDto;
import com.smalleats.service.AuthenticationService;
import com.smalleats.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "/user/userinfo",method = RequestMethod.GET)
    public ResponseEntity<?> getUserInfo(){
        return ResponseEntity.ok(userService.getUserInfo());
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public ResponseEntity<?> userLogout(HttpServletRequest request, HttpServletResponse response){

        return ResponseEntity.ok(userService.userLogout(request, response));
    }
    @RequestMapping(value = "/user/password/change", method = RequestMethod.PUT)
    public ResponseEntity<?> userPasswordChange(@RequestBody PasswordReqDto passwordReqDto){
        return ResponseEntity.ok(userService.userPasswordchange(passwordReqDto));
    }
}
