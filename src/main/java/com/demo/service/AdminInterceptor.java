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
public class AdminInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(authHeader);
            String decodedString = new String(decodedBytes);
            User user = JSON.parseObject(decodedString, User.class);
            UserContext.setUser(user);
            return true;
        }
        response.sendRedirect("/error/permission");
        return false;

    }

    public static void main(String[] args) {
        byte[] str = Base64.getEncoder().encode("{\"userId\":\"1234\",\"role\":\"test\"}".getBytes());
        System.out.println(new String(str));
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
