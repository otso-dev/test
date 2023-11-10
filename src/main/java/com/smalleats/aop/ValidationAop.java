package com.smalleats.aop;

import com.smalleats.service.exception.CustomException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
@Aspect
@Component
public class ValidationAop {

    //@CustomValid 어노테이션을 가진 method에 한해서 pointCut 동작
    @Pointcut("@annotation(com.smalleats.aop.CustomValid)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        //method에 있는 매개변수들을 다 가져온다. joinPoint를 통해서
        Object[] args = joinPoint.getArgs();

        //매개변수를 담을 bindingResult를 생성
        BindingResult bindingResult = null;

        for(Object arg: args){
            //매개변수들 중에 만약 bindingReslut가 있다면
            if(arg.getClass() == BeanPropertyBindingResult.class){
                //bindingResult에 넣어줌
                bindingResult = (BeanPropertyBindingResult) arg;
            }
        }
        //담겨진 bindingResult에 유효성 검사를 하는데 error가 발생하면 errorMap에 넣어서 예외를 던져준다.
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();

            bindingResult.getFieldErrors().forEach(error ->{
                errorMap.put(error.getField(),error.getDefaultMessage());
            });

            throw new CustomException("Validation Failed", errorMap);
        }
        return joinPoint.proceed();
    }
}
