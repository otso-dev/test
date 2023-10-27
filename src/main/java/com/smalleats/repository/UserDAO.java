package com.smalleats.repository;

import com.smalleats.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDAO {
    User findUserByEmail(String email);
    int saveUser(User user);
    int addAuthority(Authority authority);

    int passwordUpdate(Map<String, String> passwordMap);

    PartnerUser findPartnerUserByEmail(String email);
    int savePartnerUser(PartnerUser partnerUser);

    List<Order> getUserOrderList(int userId);

    List<OrderMenu> getUserOrderMenuList(int userId);

}
