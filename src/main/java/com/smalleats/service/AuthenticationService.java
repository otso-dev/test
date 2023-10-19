package com.smalleats.service;

import com.smalleats.DTO.auth.AuthoritiesRespDto;
import com.smalleats.DTO.auth.JwtTokenRespDto;
import com.smalleats.DTO.user.LoginReqDto;
import com.smalleats.DTO.user.SignupReqDto;
import com.smalleats.entity.Authority;
import com.smalleats.entity.User;
import com.smalleats.jwt.TokenProvider;
import com.smalleats.repository.UserDAOImpl;
import com.smalleats.security.PrincipalUser;
import com.smalleats.service.exception.CustomException;
import com.smalleats.service.exception.ErrorMap;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


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

    public Map<String,String> login(LoginReqDto loginReqDto, HttpServletResponse response){
        Map<String,String> loginResp = new HashMap<>();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginReqDto.getEmail(), loginReqDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        User userEntity = userDAO.findUserByEmail(loginReqDto.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(loginReqDto.getPassword(),userEntity.getPassword())){
            throw new CustomException("로그인 실패",ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        JwtTokenRespDto jwtTokenRespDto = tokenProvider.generateToken(authentication);
        Cookie cookie = new Cookie("JWT-TOKEN","Bearer=" + jwtTokenRespDto.getAccessToken());
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        loginResp.put("data","ok");
        return loginResp;
    }

    public boolean authenticated(String accessToken){
        return tokenProvider.validateToken(accessToken);
    }

    public AuthoritiesRespDto getAuthorities(String token){
        boolean validateToken = tokenProvider.validateToken(token);
        if(!validateToken){
            throw new CustomException("잘못된 접근입니다.");
        }
        Claims claims = tokenProvider.getClaims(token);
        PrincipalUser principalUser = (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new AuthoritiesRespDto(principalUser.getUsername(),(String)claims.get("auth"));
    }

}
