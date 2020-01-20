package com.wufan.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 注册控制器
 * @author Kirsh
 * @date 2020/1/16 10:11
 */
@Controller
public class RegisterController {
    /**
     * 跳转注册页
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }
}
