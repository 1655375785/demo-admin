package com.demo.rest;

import com.demo.param.User;
import com.demo.utils.UserContext;
import com.demo.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lw on @date 2024/4/26.
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/{resource}")
    public String view(String str){
        return "success";
    }

}
