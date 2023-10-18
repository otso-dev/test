package com.smalleats.controller.advice;


import com.smalleats.DTO.errorDTO.ErrorRespDto;
import com.smalleats.service.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customException(CustomException e){
        return ResponseEntity.badRequest().body(new ErrorRespDto<>(e.getMessage(),e.getErrorMap()));
    }
}
