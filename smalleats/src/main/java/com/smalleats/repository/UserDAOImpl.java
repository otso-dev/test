package com.smalleats.repository;

import com.smalleats.entity.Authority;
import com.smalleats.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAOImpl {
    public User findUserByEmail(String email);
    public int saveUser(User user);
    public int addAuthority(Authority authority);

}
