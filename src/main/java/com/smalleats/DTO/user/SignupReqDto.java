package com.smalleats.DTO.user;

import com.smalleats.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupReqDto {
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
