package com.smalleats.repository;

import com.smalleats.entity.FoodDeliveryArea;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class OrderDAOImpl implements OrderDAO{
    private final String NS = "OrderDAOImpl.";
    private final SqlSessionTemplate sqlSession;

    @Override
    public int orderInsert(Order order) {
        return sqlSession.insert(NS+"orderInsert",order);
    }
    @Override
    public int orderMenuInsert(OrderMenu orderMenuList) {
        return sqlSession.insert(NS + "orderMenuInsert",orderMenuList);
    }

    @Override
    public FoodDeliveryArea findByDeliveryArea(Map<String,String> requestMap) {
        return sqlSession.selectOne(NS+"findByDeliveryArea", requestMap);
    }

    @Override
    public List<Payment> findByDeliveryDate(int foodId) {
        return sqlSession.selectList(NS+"findByDeliveryDate",foodId);
    }

    @Override
    public OrderMenu getOrderMent(int orderId) {
        return sqlSession.selectOne(NS+"getOrderMenu",orderId);
    }
}
