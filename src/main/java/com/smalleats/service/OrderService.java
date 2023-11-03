package com.smalleats.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.smalleats.DTO.orderDTO.OrderMenuReqDto;
import com.smalleats.DTO.orderDTO.OrderReqDto;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.repository.OrderDAO;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;

    @Transactional
    public int orderInsert(OrderReqDto orderReqDto){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order = orderReqDto.toEntity(principalUser.getUserId());

        int orderResult = orderDAO.orderInsert(order);
        if(orderResult <= 0){
            throw new CustomException("주문실패");
        }

        Map<String,OrderMenuReqDto> orderMenuMap = orderReqDto.getOrderMenu();
        for(String key : orderMenuMap.keySet()){
            OrderMenuReqDto orderMenuReqDto = orderMenuMap.get(key);
            System.out.println(orderMenuReqDto);
        }


//        JSONObject jsonObject = new JSONObject(orderMenuMap.get());

        OrderMenuReqDto orderMenuReqDto = new OrderMenuReqDto();

//        int orderMenuResult = orderDAO.orderMenuInsert(orderMenuReqDto.toEntity(order.getOrderId(),jsonObject));

//        if(orderMenuResult <= 0){
//            throw new CustomException("주문실패");
//        }

        return order.getOrderId();
    }
}
