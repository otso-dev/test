package com.smalleats.service;

import com.smalleats.DTO.auth.JwtTokenRespDto;
import com.smalleats.DTO.user.LoginReqDto;
import com.smalleats.DTO.user.SignupReqDto;
import com.smalleats.entity.Authority;
import com.smalleats.entity.User;
import com.smalleats.jwt.TokenProvider;
import com.smalleats.repository.UserDAOImpl;
import com.smalleats.service.exception.CustomException;
import com.smalleats.service.exception.ErrorMap;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        System.out.println("userlogin");
        if(user == null){
            throw new CustomException("로그인 실패", ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        return user.toPrincipal();
    }
    public void checkDuplicatedEmail(String email){
        User findUser = userDAO.findUserByEmail(email);
        if(findUser != null){
            throw new CustomException("회원가입 실패",ErrorMap.builder().put("register","이미 가입한 email이 있습니다.").build());
        }
    }
    public void saveUser(SignupReqDto signupReqDto){
        User saveUser = signupReqDto.toEntity();
        userDAO.saveUser(saveUser);
        userDAO.addAuthority(Authority.builder().userId(saveUser.getUserId()).roleId(1).build());
    }

    public JwtTokenRespDto login(LoginReqDto loginReqDto){
        User userEntity = userDAO.findUserByEmail(loginReqDto.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(loginReqDto.getPassword(),userEntity.getPassword())){
            throw new CustomException("로그인 실패",ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginReqDto.getEmail(), loginReqDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        return tokenProvider.generateToken(authentication);
    }

    public boolean authenticated(String accessToken){
        return tokenProvider.validateToken(tokenProvider.getToken(accessToken));
    }

}
