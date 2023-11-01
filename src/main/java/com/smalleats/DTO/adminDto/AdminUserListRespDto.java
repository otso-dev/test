package com.smalleats.DTO.adminDto;

import com.smalleats.entity.Authority;
import com.smalleats.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserListRespDto {
    private int userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private String roleName;

    public AdminUserListRespDto toDto(Authority user){
        return AdminUserListRespDto.builder()
                .userId(user.getUser().getUserId())
                .userName(user.getUser().getUserName())
                .email(user.getUser().getEmail())
                .phoneNumber(user.getUser().getPhoneNumber())
                .roleName(user.getRole().getRoleName())
                .build();
    }
}
