package com.smalleats.service;

import com.smalleats.DTO.user.UserAddressReqDto;
import com.smalleats.DTO.user.UserAddressRespDto;
import com.smalleats.entity.User;
import com.smalleats.entity.UserAddress;
import com.smalleats.repository.UserAddressDAO;
import com.smalleats.repository.UserDAO;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserAddressService {
    private final UserAddressDAO userAddressDAO;
    private final UserDAO userDAO;

    public int UserAddressInsert(UserAddressReqDto userAddressReqDto){
        PrincipalUser principalUser = getPrincipal();
        User user = userDAO.findUserByEmail(principalUser.getEmail());
        boolean userAddressMaxFlag = userAddressMax();
        if(!userAddressMaxFlag){
            throw new CustomException("저장 할 수 있는 주소는 최대 5개 입니다.");
        }
        return userAddressDAO.userAddressInsert(userAddressReqDto.toEntity(user.getUserId()));
    }

    public List<UserAddressRespDto> getUserAddressList(){
        UserAddressRespDto userAddressRespDto = new UserAddressRespDto();
        PrincipalUser principalUser = getPrincipal();
        List<UserAddressRespDto> userAddressRespList = new ArrayList<>();
        List<UserAddress> userAddressList = userAddressDAO.getUserAddressList(principalUser.getUserId());
        userAddressList.forEach(userAddress -> {
            userAddressRespList.add(userAddressRespDto.toDto(userAddress));
        });
        return userAddressRespList;
    }

    public int UserAddressUpdate(UserAddressReqDto userAddressReqDto){
        PrincipalUser principalUser = getPrincipal();
        return userAddressDAO.userAddressUpdate(userAddressReqDto.toEntity(principalUser.getUserId()));
    }

    public int userAddressDefault(Map<String,Integer> requestMap){
        PrincipalUser principalUser = getPrincipal();
        requestMap.put("userId", principalUser.getUserId());
        System.out.println(requestMap.get("userId"));
        System.out.println(requestMap.get("addressId"));
        return userAddressDAO.userAddressDefault(requestMap);
    }

    public int userAddressDelete(int userAddressId){
        return userAddressDAO.userAddressDelete(userAddressId);
    }

    private PrincipalUser getPrincipal(){
        return (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private boolean userAddressMax(){
        int userAddressMaxCount = 5;
        PrincipalUser principalUser = getPrincipal();
        int userAddressCount = userAddressDAO.userAddressMax(principalUser.getUserId());
        System.out.println(userAddressCount);
        return userAddressMaxCount >= userAddressCount;
    }
}
