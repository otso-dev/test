package com.smalleats.service;

import com.smalleats.DTO.user.UserAddressReqDto;
import com.smalleats.DTO.user.UserAddressRespDto;
import com.smalleats.entity.User;
import com.smalleats.entity.UserAddress;
import com.smalleats.repository.UserAddressDAO;
import com.smalleats.repository.UserDAO;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import lombok.NonNull;
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

        if(principalUser == null){
            return null;
        }

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

        return userAddressDAO.userAddressDefault(requestMap);
    }

    public int userAddressDelete(int userAddressId){
        return userAddressDAO.userAddressDelete(userAddressId);
    }

    private PrincipalUser getPrincipal(){
        PrincipalUser principalUser;
        try {
            principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
        return principalUser;
    }

    private boolean userAddressMax(){
        PrincipalUser principalUser = getPrincipal();
        //유저가 등록할 수 있는 최대 주소 개수
        int userAddressMaxCount = 5;

        int userAddressCount = userAddressDAO.userAddressMax(principalUser.getUserId());

        return userAddressMaxCount >= userAddressCount;
    }
}
