package com.smalleats.repository;

import com.smalleats.entity.Authority;
import com.smalleats.entity.User;
import com.smalleats.entity.UserAddress;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO implements UserDAOImpl{

    private final String NS = "";
    private final SqlSessionTemplate sqlSession;
    public User findUserByEmail(String email) {
        return sqlSession.selectOne(NS + "findUserByEmail", email);
        // selectOne() 메소드를 사용하여 단일 결과를 반환하는 것이 좋다.
    }

    @Override
    public int saveUser(User user) {
        return sqlSession.insert(NS + "saveUser" ,user);
    }

    @Override
    public int addAuthority(Authority authority) {
        return sqlSession.insert(NS + "addAuthority" ,authority);
    }

}
