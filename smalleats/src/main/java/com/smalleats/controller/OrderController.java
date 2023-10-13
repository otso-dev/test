package com.smalleats.controller;

import com.smalleats.DTO.orderDTO.OrderReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping(value = "/order/payment",method = RequestMethod.POST)
    public ResponseEntity<?> getOrder(@RequestBody OrderReqDto orderReqDto){
        System.out.println(orderReqDto);
        return ResponseEntity.ok(true);
    }
}
