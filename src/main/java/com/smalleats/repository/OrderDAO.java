package com.smalleats.repository;

import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDAO {

    int orderInsert(Order order);

    int orderMenuInsert(OrderMenu orderMenuList);

    FoodDeliveryArea findByDeliveryArea(Map<String,String> requestMap);
}
