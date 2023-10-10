package com.smalleats.repository;

import com.smalleats.entity.UserAddress;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserAddressDAO implements UserAddressDAOImpl{
    private final String NS = "";
    private final SqlSessionTemplate sqlSession;

    @Override
    public int userAddressInsert(UserAddress userAddress) {
        return sqlSession.insert(NS + "userAddressInsert", userAddress);
    }

    @Override
    public List<UserAddress> getUserAddressList(int userId) {
        return sqlSession.selectList(NS + "getUserAddressList", userId);
    }
}
