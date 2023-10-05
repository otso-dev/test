package com.smalleats.service;

import com.smalleats.DTO.user.UserInfoRespDto;
import com.smalleats.entity.User;
import com.smalleats.repository.UserDAOImpl;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import com.smalleats.service.exception.ErrorMap;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAOImpl userDAO;

    public UserInfoRespDto getUserInfo(){
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(principalUser.toString());
        User user = userDAO.findUserByEmail(principalUser.getEmail());
        if(user == null){
            throw new CustomException("사용자 정보 오류",ErrorMap.builder().put("userInfo","사용자 정보 오류").build());
        }
        return user.toUserInfoRespDto();
    }

}
