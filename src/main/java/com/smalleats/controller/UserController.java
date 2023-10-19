package com.smalleats.controller;

import com.smalleats.DTO.user.PasswordReqDto;
import com.smalleats.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "/user/userinfo",method = RequestMethod.GET)
    public ResponseEntity<?> getUserInfo(){
        return ResponseEntity.ok(userService.getUserInfo());
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public ResponseEntity<?> userLogout(HttpServletResponse response){

        return ResponseEntity.ok(userService.userLogout(response));
    }
    @RequestMapping(value = "/user/password/change", method = RequestMethod.PUT)
    public ResponseEntity<?> userPasswordChange(@RequestBody PasswordReqDto passwordReqDto){
        return ResponseEntity.ok(userService.userPasswordchange(passwordReqDto));
    }
}
