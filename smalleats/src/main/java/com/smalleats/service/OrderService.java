package com.smalleats.service;

import com.smalleats.DTO.orderDTO.OrderMenuReqDto;
import com.smalleats.DTO.orderDTO.OrderReqDto;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.repository.OrderDAOImpl;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAOImpl orderDAO;


    public int orderInsert(OrderReqDto orderReqDto){
        Order order = new Order();
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order.setFoodId(orderReqDto.getFoodId());
        order.setUserId(principalUser.getUserId());
        order.setOrderReqTime(orderReqDto.getOrderReqTime());
        order.setOrderDeliveryDay(orderReqDto.getOrderReqDeliveryDay());
        System.out.println(order);
        int orderResult = orderDAO.orderInsert(order);
        if(orderResult == 0){
            throw new CustomException("주문실패");
        }
        Map<String,OrderMenuReqDto> orderMenuMap = orderReqDto.getOrderMenu();
        List<OrderMenu> orderMenuList = new ArrayList<>();
        orderMenuMap.forEach((key,value) ->{
            value.setOrderId(order.getOrderId());
            orderMenuList.add(value.toEntity());
        });
        System.out.println(orderMenuList);
        int orderMenuResult = orderDAO.orderMenuInsert(orderMenuList);
        if(orderMenuResult == 1){
            throw new CustomException("주문실패");
        }
        return 1;
    }
}
