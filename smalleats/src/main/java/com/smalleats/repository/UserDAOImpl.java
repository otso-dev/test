package com.smalleats.repository;

import com.smalleats.entity.Authority;
import com.smalleats.entity.User;
import com.smalleats.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDAOImpl {
    public User findUserByEmail(String email);
    public int saveUser(User user);
    public int addAuthority(Authority authority);

    public int passwordUpdate(Map<String, String> passwordMap);
}
