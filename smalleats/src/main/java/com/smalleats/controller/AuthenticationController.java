package com.smalleats.controller;

import com.smalleats.jwt.TokenProvider;
import com.smalleats.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @RequestMapping(value = "/authenticated",method = RequestMethod.GET)
    public ResponseEntity<?> getAuthenticated(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String getToken = null;
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("JWT-TOKEN")){
                    getToken = cookie.getValue();
                }
            }
        }
        return ResponseEntity.ok(authenticationService.authenticated(getToken));
    }
}
