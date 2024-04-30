package com.demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by lw on @date 2024/4/26.
 */
@Slf4j
@RestController
@RequestMapping("/error")
public class TestController {

    @GetMapping(value = "/permission")
    public String view(){
        return "no permission";
    }

}
