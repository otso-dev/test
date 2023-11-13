package com.smalleats.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalleats.DTO.errorDTO.ErrorRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        ErrorRespDto<?> errorRespDto = new ErrorRespDto<AuthenticationException>("로그인 후 이용 가능합니다.",e);
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(errorRespDto);
        PrintWriter out = httpServletResponse.getWriter();
        out.println(responseJson);
    }
}
