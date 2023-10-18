package com.smalleats.DTO.errorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRespDto <T>{
    private String message;
    private T data;
}
