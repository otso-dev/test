package com.smalleats.controller;

import com.smalleats.DTO.user.LoginReqDto;
import com.smalleats.DTO.user.SignupReqDto;
import com.smalleats.service.AuthenticationService;
import com.smalleats.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @RequestMapping(value = "/auth/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> userRegister(@RequestBody SignupReqDto signupReqDto){
        authenticationService.checkDuplicatedEmail(signupReqDto.getEmail());
        authenticationService.saveUser(signupReqDto);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<?> userLogin(@RequestBody LoginReqDto loginReqDto){
        return ResponseEntity.ok(authenticationService.login(loginReqDto));
    }

    @RequestMapping(value = "/user/userinfo",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserInfo(){
        return ResponseEntity.ok(userService.getUserInfo());
    }
}
