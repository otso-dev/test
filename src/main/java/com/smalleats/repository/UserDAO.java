package com.smalleats.repository;

import com.smalleats.entity.Authority;
import com.smalleats.entity.PartnerAuthority;
import com.smalleats.entity.PartnerUser;
import com.smalleats.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserDAO {
    User findUserByEmail(String email);
    int saveUser(User user);
    int addAuthority(Authority authority);

    int passwordUpdate(Map<String, String> passwordMap);

    PartnerUser findPartnerUserByEmail(String email);
    int savePartnerUser(PartnerUser partnerUser);
    int partnerAddAuthority(PartnerAuthority partnerAuthority);
}
