package com.smalleats.DTO.errorDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRespDto <T>{
    private String message;
    private T data;
}
