package com.smalleats.controller;

import com.smalleats.DTO.orderDTO.OrderMenuReqDto;
import com.smalleats.DTO.orderDTO.OrderReqDto;
import com.smalleats.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @RequestMapping(value = "/user/order",method = RequestMethod.POST)
    public ResponseEntity<?> getOrder(@RequestBody OrderReqDto orderReqDto){
        System.out.println(orderReqDto);

        return ResponseEntity.ok(orderService.orderInsert(orderReqDto));
    }
}
