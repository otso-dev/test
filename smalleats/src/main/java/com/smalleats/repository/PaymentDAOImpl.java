package com.smalleats.repository;


import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDAOImpl {

    public Order getOrder(int orderId);
    public List<OrderMenu> getOrderMenuList(int orderId);
    public int paid(Payment payment);

    public List<FoodDeliveryArea> getDeliveryArea(int orderId);
}
