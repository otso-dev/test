package com.smalleats.repository;

import com.smalleats.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAddressDAOImpl {

    public int userAddressInsert(UserAddress userAddress);
    public List<UserAddress> getUserAddressList(int userId);

    public int userAddressUpdate(UserAddress userAddress);

    public int userAddressDelete(int userAddressId);

}
