package com.smalleats.DTO.adminDto;

import com.smalleats.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserRespDto {
    private String userName;
    private String email;
    private String phoneNumber;
    private String profileImg;

    public AdminUserRespDto toDto(User user){
        return AdminUserRespDto.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .profileImg(user.getProfileImg())
                .build();
    }
}
