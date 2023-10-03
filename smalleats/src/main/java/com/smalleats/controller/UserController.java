package com.smalleats.controller;

import com.smalleats.DTO.user.SignupReqDto;
import com.smalleats.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;

    @RequestMapping(value = "/registertest", method = RequestMethod.POST)
    @ResponseBody
    public int registerTest(SignupReqDto signupReqDto){
        authenticationService.checkDuplicatedEmail(signupReqDto.getEmail());
        authenticationService.saveUser(signupReqDto);
        return 1;
    }
}
