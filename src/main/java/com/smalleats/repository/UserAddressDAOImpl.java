package com.smalleats.repository;

import com.smalleats.entity.UserAddress;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserAddressDAOImpl implements UserAddressDAO {
    private final String NS = "UserAddressDAOImpl.";
    private final SqlSessionTemplate sqlSession;

    @Override
    public int userAddressInsert(UserAddress userAddress) {
        return sqlSession.insert(NS + "userAddressInsert", userAddress);
    }

    @Override
    public List<UserAddress> getUserAddressList(int userId) {
        return sqlSession.selectList(NS + "getUserAddressList", userId);
    }

    @Override
    public int userAddressUpdate(UserAddress userAddress) {
        return sqlSession.update(NS +"userAddressUpdate", userAddress);
    }

    @Override
    public int userAddressDelete(int userAddressId) {
        return sqlSession.delete(NS + "userAddressDelete",userAddressId);
    }

    @Override
    public int userAddressMax(int userId) {
        return sqlSession.selectOne(NS+"userAddressMax",userId);
    }

    @Override
    public int userAddressDefault(Map<String, Integer> requestMap) {
        return sqlSession.update(NS+"userAddressDefault",requestMap);
    }
}
