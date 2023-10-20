package com.smalleats.repository;

import com.smalleats.entity.Authority;
import com.smalleats.entity.PartnerAuthority;
import com.smalleats.entity.PartnerUser;
import com.smalleats.entity.User;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO{

    private final String NS = "com.smalleats.repository.UserDAOImpl.";
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

    @Override
    public int passwordUpdate(Map<String,String> passwordMap) {
        return sqlSession.update(NS + "passwordUpdate", passwordMap);
    }

    @Override
    public PartnerUser findPartnerUserByEmail(String email) {
        return sqlSession.selectOne(NS+"findPartnerUserByEmail",email);
    }

    @Override
    public int savePartnerUser(PartnerUser partnerUser) {
        return sqlSession.insert(NS+"savePartnerUser", partnerUser);
    }

    @Override
    public int partnerAddAuthority(PartnerAuthority partnerAuthority) {
        return sqlSession.insert(NS+"partnerAddAuthority", partnerAuthority);
    }

}
