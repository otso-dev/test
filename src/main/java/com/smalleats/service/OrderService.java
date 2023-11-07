package com.smalleats.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.smalleats.DTO.orderDTO.OrderMenuReqDto;
import com.smalleats.DTO.orderDTO.OrderReqDto;
import com.smalleats.entity.FoodDeliveryArea;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;

    @Transactional
    public int orderInsert(OrderReqDto orderReqDto) {
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Order order = orderReqDto.toEntity(principalUser.getUserId());

        if(!findByDeliveryArea(orderReqDto.getFoodId(), orderReqDto.getOrderSiGunGu())){
            throw new CustomException("배달이 불가한 지역입니다.");
        }

        int orderResult = orderDAO.orderInsert(order);
        String orderMenuInfoAsJsonArray = getString(orderReqDto, orderResult);

        // OrderMenu 객체 생성
        OrderMenu orderMenu = OrderMenu.builder()
                .orderId(order.getOrderId())
                .menuInfo(orderMenuInfoAsJsonArray)
                .build();

        // DB에 저장
        int orderMenuResult = orderDAO.orderMenuInsert(orderMenu);
        if (orderMenuResult <= 0) {
            throw new CustomException("주문실패");
        }

        return order.getOrderId();
    }

    private String getString(OrderReqDto orderReqDto, int orderResult) {
        if (orderResult <= 0) {
            throw new CustomException("주문실패");
        }

        Map<String, OrderMenuReqDto> orderMenuMap = orderReqDto.getOrderMenu();
        List<String> orderMenuInfoList = new ArrayList<>();  // JSON 문자열을 저장할 리스트

        // Jackson 라이브러리의 ObjectMapper를 사용하여 JSON 문자열로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        for (String key : orderMenuMap.keySet()) {
            OrderMenuReqDto orderMenuReqDto = orderMenuMap.get(key);
            try {
                // JSON 문자열로 변환
                String orderMenuInfoAsJson = objectMapper.writeValueAsString(orderMenuReqDto);

                // JSON 문자열을 리스트에 추가
                orderMenuInfoList.add(orderMenuInfoAsJson);
            } catch (Exception e) {
                throw new CustomException("JSON 변환 실패");
            }
        }

        // JSON 배열로 변환
        return orderMenuInfoList.toString();
    }

    private boolean findByDeliveryArea(int foodId, String SiGunGu){
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("foodId", String.valueOf(foodId));
        requestMap.put("SiGunGu", SiGunGu);
        FoodDeliveryArea foodDeliveryArea = orderDAO.findByDeliveryArea(requestMap);
        return foodDeliveryArea != null;
    }
}