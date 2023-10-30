package com.smalleats.repository.admin;

import com.smalleats.entity.Authority;
import com.smalleats.entity.PartnerUser;
import com.smalleats.entity.User;
import com.smalleats.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminUserManageDAO {
    List<Authority> adminUserSelect();
    List<PartnerUser> adminPartnerUserSelect();
    User getUserDetail(int userId);
    List<UserAddress> getUserAddressList(int userId);
}
