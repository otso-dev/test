package com.smalleats.repository;

import com.smalleats.entity.Authority;
import com.smalleats.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserDAO {
    User findUserByEmail(String email);
    int saveUser(User user);
    int addAuthority(Authority authority);

    int passwordUpdate(Map<String, String> passwordMap);
}
