package com.smalleats.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @GetMapping(value = "/authenticated")
    public ResponseEntity<?> getAuthenticated(){
        return ResponseEntity.ok(true);
    }

}
