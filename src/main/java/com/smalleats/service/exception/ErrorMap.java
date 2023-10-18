package com.smalleats.service.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorMap {
    private final Map<String,String> errorMap;

    public ErrorMap(){
        errorMap = new HashMap<>();
    }
    public static ErrorMap builder(){
        return new ErrorMap();
    }

    public ErrorMap put(String key, String value){
        errorMap.put(key,value);
        return this;
    }

    public Map<String, String> build(){
        return errorMap;
    }
}
