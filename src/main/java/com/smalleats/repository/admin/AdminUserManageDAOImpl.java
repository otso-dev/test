package com.smalleats.repository.admin;

import com.smalleats.entity.Authority;
import com.smalleats.entity.PartnerUser;
import com.smalleats.entity.User;
import com.smalleats.entity.UserAddress;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminUserManageDAOImpl implements AdminUserManageDAO{
    private final String NS = "AdminUserManageDAOImpl.";
    private final SqlSessionTemplate sqlSession;

    @Override
    public List<Authority> adminUserSelect() {
        return sqlSession.selectList(NS+"adminUserSelect");
    }

    @Override
    public List<PartnerUser> adminPartnerUserSelect() {
        return sqlSession.selectList(NS+"adminPartnerUserSelect");
    }

    @Override
    public User getUserDetail(int userId) {
        return sqlSession.selectOne(NS+"getUserDetail",userId);
    }

    @Override
    public PartnerUser getPartnerUser(int partnerId) {
        return sqlSession.selectOne(NS +"getPartnerUser", partnerId);
    }
    @Override
    public List<UserAddress> getUserAddressList(int userId) {
        return sqlSession.selectList(NS+"getUserAddressList",userId);
    }
}
