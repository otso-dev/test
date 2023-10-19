package com.smalleats.repository;

import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAOImpl implements OrderDAO{
    private final String NS = "com.smalleats.repository.OrderDAOImpl.";
    private final SqlSessionTemplate sqlSession;

    @Override
    public int orderInsert(Order order) {
        return sqlSession.insert(NS+"orderInsert",order);
    }
    @Override
    public int orderMenuInsert(List<OrderMenu> orderMenuList) {
        return sqlSession.insert(NS + "orderMenuInsert",orderMenuList);
    }
}
