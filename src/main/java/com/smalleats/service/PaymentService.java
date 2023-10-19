package com.smalleats.service;


import com.smalleats.DTO.paymentDTO.PaidReqDto;
import com.smalleats.DTO.paymentDTO.PaymentMenuRespDto;
import com.smalleats.DTO.paymentDTO.PaymentOrderRespDto;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.repository.PaymentDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentDAOImpl paymentDAO;

    public PaymentOrderRespDto getOrder(int orderId){
        PaymentOrderRespDto paymentOrderRespDto = new PaymentOrderRespDto();
        Order order = paymentDAO.getOrder(orderId);
        return paymentOrderRespDto.toEntity(order);
    }
    public List<PaymentMenuRespDto> getOrderMenuList(int orderId){
        PaymentMenuRespDto paymentMenuRespDto = new PaymentMenuRespDto();
        List<PaymentMenuRespDto> menuRespDtoList = new ArrayList<>();
        List<OrderMenu> orderMenuList = paymentDAO.getOrderMenuList(orderId);
        orderMenuList.forEach(orderMenu -> {
            menuRespDtoList.add(paymentMenuRespDto.toEntity(orderMenu));
        });
        return menuRespDtoList;
    }

    public int paid(PaidReqDto paidReqDto){
        return paymentDAO.paid(paidReqDto.toEntity());
    }
}
