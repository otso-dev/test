package com.smalleats.service;

import com.smalleats.DTO.user.UserAddressReqDto;
import com.smalleats.DTO.user.UserAddressRespDto;
import com.smalleats.entity.User;
import com.smalleats.entity.UserAddress;
import com.smalleats.repository.UserAddressDAOImpl;
import com.smalleats.repository.UserDAOImpl;
import com.smalleats.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAddressService {
    private final UserAddressDAOImpl userAddressDAO;
    private final UserDAOImpl userDAO;
    public int UserAddressInsert(UserAddressReqDto userAddressReqDto){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDAO.findUserByEmail(principalUser.getEmail());
        return userAddressDAO.userAddressInsert(userAddressReqDto.toEntity(user.getUserId()));
    }

    public List<UserAddressRespDto> getUserAddressList(){
        UserAddressRespDto userAddressRespDto = new UserAddressRespDto();
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<UserAddressRespDto> userAddressRespList = new ArrayList<>();
        List<UserAddress> userAddressList = userAddressDAO.getUserAddressList(principalUser.getUserId());
        userAddressList.forEach(userAddress -> {
            userAddressRespList.add(userAddressRespDto.toEntity(userAddress));
        });
        return userAddressRespList;
    }

    public int UserAddressUpdate(UserAddressReqDto userAddressReqDto){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userAddressDAO.userAddressUpdate(userAddressReqDto.toEntity(principalUser.getUserId()));
    }

    public int userAddressDelete(int userAddressId){
        return userAddressDAO.userAddressDelete(userAddressId);
    }
}
