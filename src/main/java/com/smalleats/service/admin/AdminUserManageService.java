package com.smalleats.service.admin;

import com.smalleats.DTO.adminDto.AdminPartnerUserListRespDto;
import com.smalleats.DTO.adminDto.AdminUserAddressListRespDto;
import com.smalleats.DTO.adminDto.AdminUserListRespDto;
import com.smalleats.DTO.adminDto.AdminUserRespDto;
import com.smalleats.entity.Authority;
import com.smalleats.entity.PartnerUser;
import com.smalleats.entity.User;
import com.smalleats.entity.UserAddress;
import com.smalleats.repository.admin.AdminUserManageDAO;
import com.smalleats.repository.partner.PartnerFoodDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserManageService {
    private final AdminUserManageDAO adminUserManageDAO;

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
}
