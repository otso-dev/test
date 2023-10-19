package com.smalleats.repository;

import com.smalleats.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAddressDAO {

    int userAddressInsert(UserAddress userAddress);
    List<UserAddress> getUserAddressList(int userId);

    int userAddressUpdate(UserAddress userAddress);

    int userAddressDelete(int userAddressId);

}
