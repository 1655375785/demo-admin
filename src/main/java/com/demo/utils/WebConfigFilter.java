package com.demo.utils;

import com.demo.service.AdminInterceptor;
import com.demo.service.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Create by lw on @date 2024/4/29.
 */
@Configuration
public class WebConfigFilter implements WebMvcConfigurer{

    @Autowired
    private AdminInterceptor adminInterceptor;
    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(adminInterceptor).addPathPatterns("/**").excludePathPatterns("/error/**");
        registry.addInterceptor(userInterceptor).addPathPatterns("/user/**").excludePathPatterns("/error/**");

    }
}
