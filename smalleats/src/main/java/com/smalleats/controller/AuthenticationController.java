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
    private final TokenProvider tokenProvider;
    @RequestMapping(value = "/authenticated",method = RequestMethod.GET)
    public ResponseEntity<?> getAuthenticated(@RequestHeader("Cookie") String Cookie){
        Cookie = tokenProvider.getCookieToken(Cookie);
        return ResponseEntity.ok(authenticationService.authenticated(Cookie));
    }
    @RequestMapping(value = "/authorities",method = RequestMethod.GET)
    public ResponseEntity<?> getAuthorities(@RequestHeader("Cookie") String Cookie){
        Cookie = tokenProvider.getCookieToken(Cookie);
        return ResponseEntity.ok().body(authenticationService.getAuthorities(Cookie));
    }
}
