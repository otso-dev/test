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
    public List<PaymentMenuRespDto> getOrderMenuList(int orderId){
        PaymentMenuRespDto paymentMenuRespDto = new PaymentMenuRespDto();
        List<PaymentMenuRespDto> menuRespDtoList = new ArrayList<>();
        List<OrderMenu> orderMenuList = paymentDAO.getOrderMenuList(orderId);
        orderMenuList.forEach(orderMenu -> {
            menuRespDtoList.add(paymentMenuRespDto.toDto(orderMenu));
        });
        return menuRespDtoList;
    }

    public int paid(PaidReqDto paidReqDto){
        return paymentDAO.paid(paidReqDto.toEntity());
    }
}
