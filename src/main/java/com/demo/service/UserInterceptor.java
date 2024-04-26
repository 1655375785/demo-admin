package com.demo.service;

import com.alibaba.fastjson.JSON;
import com.demo.param.User;
import com.demo.utils.UserContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Component
public class UserInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        String[] parts = requestURI.split("/");
        if(parts.length < 1){
            return false;
        }
        String lastPart = parts[parts.length - 1];
        User user = UserContext.getUser();
        String[] resources = user.getEndpoint();
        for (int i = 0; i < resources.length; i++) {
            if(lastPart.equals(resources[i])){
                return true;
            }
        }
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
