package com.smalleats.service.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smalleats.DTO.adminDto.*;
import com.smalleats.DTO.user.UserOrderListRespDto;
import com.smalleats.entity.*;
import com.smalleats.repository.UserDAO;
import com.smalleats.repository.admin.AdminUserManageDAO;
import com.smalleats.repository.partner.PartnerFoodDAO;
import com.smalleats.service.UserService;
import com.smalleats.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserManageService {
    private final AdminUserManageDAO adminUserManageDAO;
    private final PartnerFoodDAO partnerFoodDAO;
    private final UserDAO userDAO;

    public List<AdminUserListRespDto> adminUserSelectList(){
        AdminUserListRespDto adminUserListRespDto = new AdminUserListRespDto();
        List<AdminUserListRespDto> adminUserListRespDtoList = new ArrayList<>();
        List<Authority> userList = adminUserManageDAO.adminUserSelect();
        userList.forEach(user ->{
            adminUserListRespDtoList.add(adminUserListRespDto.toDto(user));
        });
        return adminUserListRespDtoList;
    }
    public List<AdminPartnerUserListRespDto> adminPartnerUserSelectList(){
        AdminPartnerUserListRespDto adminPartnerUserListRespDto = new AdminPartnerUserListRespDto();
        List<AdminPartnerUserListRespDto> adminPartnerUserListRespDtoList = new ArrayList<>();
        List<PartnerUser> partnerUserList = adminUserManageDAO.adminPartnerUserSelect();
        partnerUserList.forEach(partnerUser -> {
            adminPartnerUserListRespDtoList.add(adminPartnerUserListRespDto.toDto(partnerUser));
        });
        return adminPartnerUserListRespDtoList;
    }
    public AdminUserRespDto getUserDetail(int userId){
        AdminUserRespDto adminUserRespDto = new AdminUserRespDto();
        User user = adminUserManageDAO.getUserDetail(userId);
        return adminUserRespDto.toDto(user);
    }
    public List<AdminUserAddressListRespDto> getUserAddressList(int userId){
        AdminUserAddressListRespDto adminUserAddressListRespDto = new AdminUserAddressListRespDto();
        List<UserAddress> userAddressList = adminUserManageDAO.getUserAddressList(userId);
        List<AdminUserAddressListRespDto> userAddressListRespDtos = new ArrayList<>();
        userAddressList.forEach(userAddress -> {
            userAddressListRespDtos.add(adminUserAddressListRespDto.toDto(userAddress));
        });
        return userAddressListRespDtos;
    }
    public AdminPartnerUserRespDto getPartnerUser(int partnerId){
        AdminPartnerUserRespDto adminPartnerUserRespDto = new AdminPartnerUserRespDto();
        PartnerUser partnerUser = adminUserManageDAO.getPartnerUser(partnerId);
        return adminPartnerUserRespDto.toDto(partnerUser);
    }
    public AdminPendingFoodRespDto getPendingFood(int partnerId){
        AdminPendingFoodRespDto adminPendingFoodRespDto = new AdminPendingFoodRespDto();
        PendingFood pendingFood = partnerFoodDAO.getPendingFood(partnerId);
        if(pendingFood == null){
            return adminPendingFoodRespDto;
        }
        return adminPendingFoodRespDto.toDto(pendingFood);
    }

    public List<UserOrderListRespDto> getUserOrderList(int userId){

        UserOrderListRespDto userOrderListRespDto = new UserOrderListRespDto();

        List<UserOrderListRespDto> userOrderListRespDtoList = new ArrayList<>();
        List<Payment> userOrderList = userDAO.getUserOrderList(userId);

        userOrderList.forEach(payment -> {
            try {
                userOrderListRespDtoList.add(userOrderListRespDto.toDto(payment));
            } catch (Exception e) {
                throw new CustomException("JSON 파싱 실패");
            }
        });
        return userOrderListRespDtoList;
    }
}
