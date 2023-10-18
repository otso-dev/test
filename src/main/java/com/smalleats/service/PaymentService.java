package com.smalleats.service;

import com.smalleats.DTO.foodProductDTO.ProductDetailRespDto;
import com.smalleats.DTO.paymentDTO.PaidReqDto;
import com.smalleats.DTO.paymentDTO.PaymentMenuRespDto;
import com.smalleats.DTO.paymentDTO.PaymentOrderRespDto;
import com.smalleats.entity.FoodProduct;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.entity.Payment;
import com.smalleats.repository.FoodProductDAOImpl;
import com.smalleats.repository.PaymentDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentDAOImpl paymentDAO;

    public PaymentOrderRespDto getOrder(int orderId){
        Order order = paymentDAO.getOrder(orderId);
        return order.toPaymentOrder();
    }
    public List<PaymentMenuRespDto> getOrderMenuList(int orderId){
        List<PaymentMenuRespDto> menuRespDtoList = new ArrayList<>();
        List<OrderMenu> orderMenuList = paymentDAO.getOrderMenuList(orderId);
        orderMenuList.forEach(orderMenu -> {
            menuRespDtoList.add(orderMenu.toPaymentMenu());
        });
        return menuRespDtoList;
    }

    public int paid(PaidReqDto paidReqDto){
        return paymentDAO.paid(paidReqDto.toEntity());
    }
}
