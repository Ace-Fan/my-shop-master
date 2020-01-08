package com.wufan.my.shop.web.admin.web.controller;

import com.wufan.my.shop.commons.constant.ConstantUtils;
import com.wufan.my.shop.commons.utils.CookieUtils;
import com.wufan.my.shop.domain.TbUser;
import com.wufan.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：WuFan
 * @date ：Created in 2019/11/16 0016 22:14
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;
    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登录逻辑
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Model model){
        boolean isRemember = httpServletRequest.getParameter("isRemember") == null ? false : true;
        //
        TbUser tbUser = tbUserService.login(email, password);
        //失败
        if(tbUser == null){
            model.addAttribute("message","用户名或密码错误，请重新输入");
            return login();
        }
        //成功
        else {
            if(isRemember){
                //用户信息存储一周
                CookieUtils.setCookie(httpServletRequest,httpServletResponse,"userInfo",String.format("%s:%s",email,password),7 * 24 * 60 * 60);
            }
            //将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,tbUser);
            return "/main";
        }
    }

    @RequestMapping(value = "loginout",method = RequestMethod.GET)
    public String loginout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return login();
    }
}
