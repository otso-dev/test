package com.smalleats.DTO.adminDto;

import com.smalleats.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminRegisterReqDto {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;


    public User toEntity(){
        return User.builder()
                .userName(userName)
                .email(email)
                .password(new BCryptPasswordEncoder().encode(password))
                .phoneNumber(phoneNumber)
                .build();
    }
}
