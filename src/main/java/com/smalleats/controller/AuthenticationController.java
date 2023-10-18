package com.smalleats.controller;

import com.smalleats.DTO.user.LoginReqDto;
import com.smalleats.DTO.user.SignupReqDto;
import com.smalleats.jwt.TokenProvider;
import com.smalleats.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final TokenProvider tokenProvider;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> userRegister(@RequestBody SignupReqDto signupReqDto){
        authenticationService.checkDuplicatedEmail(signupReqDto.getEmail());
        authenticationService.saveUser(signupReqDto);
        return ResponseEntity.ok(true);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<?> userLogin(HttpServletResponse response, @RequestBody LoginReqDto loginReqDto){
        return ResponseEntity.ok(authenticationService.login(loginReqDto,response));
    }

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
