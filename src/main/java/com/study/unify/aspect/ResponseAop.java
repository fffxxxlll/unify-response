package com.study.unify.aspect;

import com.study.unify.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author fff
 * @date 2022/3/31 0031 9:48
 * @description 使用aop定义拦截器
 */

@Slf4j
@Aspect
@Component
public class ResponseAop {

    private static final String RESPONSE_RESULT_ANNO = "RESPONSE_RESULT_ANNO";

    //@Around("@within(com.study.unify.annotation.ResponseResult)")//这个切点表达式只作用在类上
    @Around("@annotation(com.study.unify.annotation.ResponseResult)")//这个切点表达式的作用只用在方法上
    public Object processAop(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            log.info("开始切入");
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Class<?> clazz = joinPoint.getTarget().getClass();
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_RESULT_ANNO, clazz.getAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_RESULT_ANNO, method.getAnnotation(ResponseResult.class));
            }
            result = joinPoint.proceed();
            log.info("目标方法执行完成");
        } catch (Throwable e) {
            log.error("切面执行出错,原因是:{}", e);
        }
        return result;
    }
}
