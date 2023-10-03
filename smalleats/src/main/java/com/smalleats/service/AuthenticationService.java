package com.smalleats.service;

import com.smalleats.DTO.auth.JwtTokenRespDto;
import com.smalleats.DTO.user.LoginReqDto;
import com.smalleats.DTO.user.SignupReqDto;
import com.smalleats.entity.Authority;
import com.smalleats.entity.User;
import com.smalleats.jwt.TokenProvider;
import com.smalleats.repository.UserDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
    private final UserDAOImpl userDAO;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findUserByEmail(email);
        if(user == null){
            return null;
        }
        return user.toPrincipal();
    }
    public int checkDuplicatedEmail(String email){
        User findUser = userDAO.findUserByEmail(email);
        if(findUser != null){
            return 1;
        }
        return 0;
    }
    public void saveUser(SignupReqDto signupReqDto){
        User saveUser = signupReqDto.toEntity();
        System.out.println(saveUser.toString()+"service");
        userDAO.saveUser(saveUser);
        userDAO.addAuthority(Authority.builder().userId(saveUser.getUserId()).roleId(1).build());
    }

    public JwtTokenRespDto login(LoginReqDto loginReqDto){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginReqDto.getEmail(), loginReqDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        return tokenProvider.generateToken(authentication);
    }

    public boolean authenticated(String accessToken){
        return tokenProvider.validateToken(tokenProvider.getToken(accessToken));
    }

}
