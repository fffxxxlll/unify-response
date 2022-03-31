package com.study.unify.config;

import com.study.unify.interceptor.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fff
 * @date 2022/3/31 0031 9:12
 * @description 使用自定义拦截器实现统一返回，此处为注册拦截器
 * @deprecated
 */

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    ResponseResultInterceptor resultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(resultInterceptor).addPathPatterns("/*");
    }
}
