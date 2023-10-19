package com.smalleats.DTO.user;

import com.smalleats.entity.User;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRespDto {
    private String username;
    private String email;
    private String phoneNumber;

    public UserInfoRespDto toEntity(User user){
        return new UserInfoRespDto(
                this.username = user.getUserName(),
                this.email = user.getEmail(),
                this.phoneNumber = user.getPhoneNumber()
        );
    }
}
