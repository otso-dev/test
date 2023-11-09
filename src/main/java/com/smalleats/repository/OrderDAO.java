package com.smalleats.repository;

import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDAO {

    int orderInsert(Order order);

    int orderMenuInsert(OrderMenu orderMenuList);

    FoodDeliveryArea findByDeliveryArea(Map<String,String> requestMap);

    List<Payment> findByDeliveryDate(int foodId);

    OrderMenu getOrderMent(int orderId);
}
