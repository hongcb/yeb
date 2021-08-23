package com.xxxx.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * swagger测试控制器
 *
 * @author hongcb
 * @version 1.0
 * @date 2021/8/17 16:24
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
