package com.smalleats.security;

import com.smalleats.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {
    private final TokenProvider tokenProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = httpServletRequest.getCookies();
        String getToken = null;
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("JWT-TOKEN")){
                    getToken = cookie.getValue();
                }
            }
        }

        String token = tokenProvider.getToken(getToken);
        if(token == null){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        boolean tokenValidate = tokenProvider.validateToken(token);
        if(tokenValidate){
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
