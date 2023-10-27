package com.smalleats.service;

import com.smalleats.DTO.partnerDto.OrderMenuRespDto;
import com.smalleats.DTO.user.PasswordReqDto;
import com.smalleats.DTO.user.UserInfoRespDto;
import com.smalleats.DTO.user.UserOrderListRespDto;
import com.smalleats.entity.Order;
import com.smalleats.entity.OrderMenu;
import com.smalleats.entity.User;
import com.smalleats.repository.UserDAO;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import com.smalleats.service.exception.ErrorMap;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public UserInfoRespDto getUserInfo(){
        PrincipalUser principalUser = getPrincipal();
        UserInfoRespDto userInfoRespDto = new UserInfoRespDto();
        User user = userDAO.findUserByEmail(principalUser.getEmail());
        if(user == null){
            throw new CustomException("사용자 정보 오류",ErrorMap.builder().put("userInfo","사용자 정보 오류").build());
        }
        return userInfoRespDto.toDto(user);
    }

    public int userLogout(HttpServletResponse response){
        Cookie jwtTokenDelete = new Cookie("JWT-TOKEN", null);
        jwtTokenDelete.setMaxAge(0);
        jwtTokenDelete.setPath("/");
        response.addCookie(jwtTokenDelete);
        return 1;
    }

    public int userPasswordChange(PasswordReqDto passwordReqDto){
        PrincipalUser principalUser = getPrincipal();
        Map<String,String> passwordMap = new HashMap<>();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = userDAO.findUserByEmail(principalUser.getEmail());
        if(!passwordEncoder.matches(passwordReqDto.getCurrentPassword(), user.getPassword())){
            throw new CustomException("비밀번호 변경 실패", ErrorMap.builder().put("password","현재 비밀번호가 일치하지 않습니다.").build());
        }
        if(!passwordReqDto.getChangePassword().equals(passwordReqDto.getCheckPassword())){
            throw new CustomException("비밀번호 변경 실패",ErrorMap.builder().put("password","비밀번호 확인과 변경할 비밀번호가 다릅니다.").build());
        }
        String encodePassword = passwordEncoder.encode(passwordReqDto.getChangePassword());
        passwordMap.put("userId", Integer.toString(user.getUserId()));
        passwordMap.put("changePassword", encodePassword);
        return userDAO.passwordUpdate(passwordMap);
    }
    public List<UserOrderListRespDto> getUserOrderList(){
        PrincipalUser principalUser = getPrincipal();
        UserOrderListRespDto userOrderListRespDto = new UserOrderListRespDto();
        OrderMenuRespDto orderMenuRespDto = new OrderMenuRespDto();
        List<Order> orderList = userDAO.getUserOrderList(principalUser.getUserId());
        List<OrderMenu> orderMenuList = userDAO.getUserOrderMenuList(principalUser.getUserId());
        List<UserOrderListRespDto> userOrderList = new ArrayList<>();
        List<OrderMenuRespDto> orderMenuRespDtoList = new ArrayList<>();
        orderList.forEach(order -> {
            userOrderList.add(userOrderListRespDto.toDto(order));
        });
        orderMenuList.forEach(orderMenu -> {
            orderMenuRespDtoList.add(orderMenuRespDto.toDto(orderMenu));
        });
        userOrderList.forEach(userOrder->{
            orderMenuRespDtoList.forEach(userOrderMenu->{
                if(userOrder.getOrderId() == userOrderMenu.getOrderId()){
                    userOrder.getUserOrderMenuList().add(userOrderMenu);
                }
            });
        });
        return userOrderList;
    }
    private PrincipalUser getPrincipal(){
        return (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
