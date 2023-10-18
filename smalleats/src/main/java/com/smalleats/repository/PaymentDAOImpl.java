package com.smalleats.repository;


import com.smalleats.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDAOImpl {

    public Order getOrder(int orderId);
}
