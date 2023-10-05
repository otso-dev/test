package com.smalleats.security;

import com.smalleats.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends GenericFilterBean {
    private final TokenProvider tokenProvider;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest httpRequest = (HttpServletRequest) request;
       String token = tokenProvider.getToken(httpRequest.getHeader("Authorization"));
       if(tokenProvider.validateToken(token)){
           Authentication authentication = tokenProvider.getAuthentication(token);
           SecurityContextHolder.getContext().setAuthentication(authentication);
       }else{
           System.out.println("token check!!");
       }
       chain.doFilter(request,response);
        System.out.println(((HttpServletRequest) request).getRequestURI());
        System.out.println(((HttpServletRequest) request).getRequestURL());
    }
}
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println(httpServletRequest.getRequestURI());
//        System.out.println(httpServletRequest.getRequestURL());
//        String token = tokenProvider.getToken(httpServletRequest.getHeader("Authorization"));
//        if(tokenProvider.validateToken(token)){
//            Authentication authentication = tokenProvider.getAuthentication(token);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//        else{
//            System.out.println("token 확인");
//        }
//        filterChain.doFilter(httpServletRequest,httpServletResponse);
//    }