package com.smalleats.repository;


import com.smalleats.entity.Order;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentDAO implements PaymentDAOImpl{
    private final String NS = "";
    private final SqlSessionTemplate sqlSession;


    @Override
    public Order getOrder(int orderId) {
        return sqlSession.selectOne(NS+"getOrder",orderId);
    }
}
