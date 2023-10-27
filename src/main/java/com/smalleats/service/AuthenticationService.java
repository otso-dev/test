package com.smalleats.service;

import com.smalleats.DTO.adminDto.AdminLoginReqDto;
import com.smalleats.DTO.adminDto.AdminRegisterReqDto;
import com.smalleats.DTO.auth.AuthoritiesRespDto;
import com.smalleats.DTO.auth.JwtTokenRespDto;
import com.smalleats.DTO.partnerDto.PartnerLoginReqDto;
import com.smalleats.DTO.partnerDto.PartnerRegisterReqDto;
import com.smalleats.DTO.user.LoginReqDto;
import com.smalleats.DTO.user.SignupReqDto;
import com.smalleats.entity.Authority;
import com.smalleats.entity.PartnerUser;
import com.smalleats.entity.User;
import com.smalleats.jwt.TokenProvider;
import com.smalleats.repository.UserDAO;
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
    private final UserDAO userDAO;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    @Override
    public PrincipalUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findUserByEmail(email);
        PartnerUser partnerUser = userDAO.findPartnerUserByEmail(email);
        System.out.println("userlogin");
        if(user == null && partnerUser == null){
            throw new CustomException("로그인 실패", ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        if(partnerUser != null && user == null) {
            return partnerUser.toPrincipal();
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
    public void saveAdmin(AdminRegisterReqDto adminRegisterReqDto){
        User saveAdmin = adminRegisterReqDto.toEntity();
        userDAO.saveUser(saveAdmin);
        userDAO.addAuthority(Authority.builder().userId(saveAdmin.getUserId()).roleId(3).build());
    }
    public Map<String,String> login(AdminLoginReqDto adminLoginReqDto, HttpServletResponse response){
        Map<String,String> loginResp = new HashMap<>();
        User userEntity = userDAO.findUserByEmail(adminLoginReqDto.getEmail());
        if(userEntity == null){
            throw new CustomException("로그인 실패",ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(adminLoginReqDto.getPassword(),userEntity.getPassword())){
            throw new CustomException("로그인 실패",ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                adminLoginReqDto.getEmail(), adminLoginReqDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);

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
    public Map<String,String> login(LoginReqDto loginReqDto, HttpServletResponse response){
        Map<String,String> loginResp = new HashMap<>();
        User userEntity = userDAO.findUserByEmail(loginReqDto.getEmail());
        if(userEntity == null){
            throw new CustomException("로그인 실패",ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(loginReqDto.getPassword(),userEntity.getPassword())){
            throw new CustomException("로그인 실패",ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginReqDto.getEmail(), loginReqDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);

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

    public void duplicatedEmail(String email){
        PartnerUser partnerUser = userDAO.findPartnerUserByEmail(email);
        if(partnerUser != null){
            throw new CustomException("email중복");
        }
    }
    public int savePartner(PartnerRegisterReqDto partnerRegisterReqDto){
        PartnerUser partnerUser = partnerRegisterReqDto.toEntity();
        int savePartner = userDAO.savePartnerUser(partnerUser);
        int partnerAddAuth = userDAO.addAuthority(Authority.builder()
                .partnerId(partnerUser.getPartnerId())
                .roleId(2)
                .build());
        if(savePartner != 1 && partnerAddAuth != 1){
            return 0;
        }
        return 1;
    }
    public Map<String,String> partnerLogin(PartnerLoginReqDto partnerLoginReqDto, HttpServletResponse response){
        Map<String,String> loginResp = new HashMap<>();
        PartnerUser partnerUser = userDAO.findPartnerUserByEmail(partnerLoginReqDto.getPartnerUserEmail());
        if(partnerUser == null){
            throw new CustomException("로그인 실패",ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(partnerLoginReqDto.getPartnerUserPassword(),partnerUser.getPartnerPassword())){
            throw new CustomException("로그인 실패", ErrorMap.builder().put("login","사용자 정보를 확인하세요").build());
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                partnerLoginReqDto.getPartnerUserEmail(),partnerLoginReqDto.getPartnerUserPassword()
        );
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        JwtTokenRespDto jwtTokenRespDto = tokenProvider.generateToken(authentication);
        Cookie cookie = new Cookie("JWT-TOKEN-PARTNER","Bearer="+jwtTokenRespDto.getAccessToken());
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 30);
        response.addCookie(cookie);
        return loginResp;
    }

}
