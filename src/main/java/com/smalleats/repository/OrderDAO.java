package com.smalleats.repository;

import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDAO {

    int orderInsert(Order order);

    int orderMenuInsert(List<OrderMenu> orderMenuList);
}
