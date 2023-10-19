package com.smalleats.DTO.user;

import com.smalleats.entity.User;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRespDto {
    private String username;
    private String email;
    private String phoneNumber;

    public UserInfoRespDto toDto(User user){
        return UserInfoRespDto.builder()
                .username(user.getUserName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
