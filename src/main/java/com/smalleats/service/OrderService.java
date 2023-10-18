package com.smalleats.service;

import com.smalleats.DTO.orderDTO.OrderMenuReqDto;
import com.smalleats.DTO.orderDTO.OrderReqDto;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.repository.OrderDAOImpl;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAOImpl orderDAO;

    public int orderInsert(OrderReqDto orderReqDto){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order = orderReqDto.toEntity(principalUser.getUserId());
        int orderResult = orderDAO.orderInsert(order);
        if(orderResult <= 0){
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
        if(orderMenuResult <= 0){
            throw new CustomException("주문실패");
        }
        return order.getOrderId();
    }
}
