package com.smalleats.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalleats.DTO.foodProductDTO.FoodDeliveryDayCountRespDto;
import com.smalleats.DTO.paymentDTO.PaidReqDto;
import com.smalleats.DTO.paymentDTO.PaymentMenuRespDto;
import com.smalleats.DTO.paymentDTO.PaymentOrderRespDto;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.repository.PaymentDAO;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentDAO paymentDAO;

    public PaymentOrderRespDto getOrder(int orderId){
        PaymentOrderRespDto paymentOrderRespDto = new PaymentOrderRespDto();
        Order order = paymentDAO.getOrder(orderId);
        return paymentOrderRespDto.toDto(order);
    }
    public List<PaymentMenuRespDto> getOrderMenuList(int orderId){
        OrderMenu orderMenu = paymentDAO.getOrderMenuList(orderId);
        String menuInfo = orderMenu.getMenuInfo();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(menuInfo, new TypeReference<List<PaymentMenuRespDto>>() {});
        } catch (Exception e) {
            throw new CustomException("JSON 파싱 실패");
        }
    }
    public int paid(PaidReqDto paidReqDto){
        return paymentDAO.paid(paidReqDto.toEntity());
    }

}
