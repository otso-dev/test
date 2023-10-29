package com.smalleats.repository.admin;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdminUserManageDAOImpl implements AdminUserManageDAO{
    private final String NS = "com.smalleats.repository.admin.AdminUserManageDAOImpl.";
    private final SqlSessionTemplate sqlSession;

}
