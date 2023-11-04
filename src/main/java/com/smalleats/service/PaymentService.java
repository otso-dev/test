package com.smalleats.service;


import com.smalleats.DTO.paymentDTO.PaidReqDto;
import com.smalleats.DTO.paymentDTO.PaymentMenuRespDto;
import com.smalleats.DTO.paymentDTO.PaymentOrderRespDto;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.repository.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public PaymentMenuRespDto getOrderMenuList(int orderId){
        PaymentMenuRespDto paymentMenuRespDto = new PaymentMenuRespDto();
        OrderMenu orderMenu = paymentDAO.getOrderMenuList(orderId);
        paymentMenuRespDto.toDto(orderMenu);
        return null;
    }

    public int paid(PaidReqDto paidReqDto){
        return paymentDAO.paid(paidReqDto.toEntity());
    }
}
