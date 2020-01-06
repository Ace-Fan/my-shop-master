package com.wufan.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ：WuFan
 * @date ：Created in 2019/11/16 0016 22:15
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
public class MainController {
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
