package com.wufan.my.shop.web.admin.web.controller;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.dto.PageInfo;
import com.wufan.my.shop.domain.TbUser;
import com.wufan.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author ：WuFan
 * @date ：Created in 2019/11/22 0022 23:27
 * @description：用户管理
 * @modified By：
 * @version: $
 */

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser = null;
        //id 不为空，从数据库获取
        if (id != null){
            tbUser = tbUserService.getById(id);
        }
        else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 跳转用户列表页
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "user_list";
    }

    /**
     * 跳转用户表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

    /**
     * 保存用户信息
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model,RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbUserService.save(tbUser);

        //保存成功
        if (baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }
    }

    /**
     * 删除用户信息
     * @param ids
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(ids)){
            String [] idArray = ids.split(",");
            tbUserService.deleteMulti(idArray);
             baseResult = BaseResult.success("批量删除成功");
        }
        else {
            baseResult = BaseResult.fail("批量删除失败");
        }
        return baseResult;
    }

    /**
     * 分页查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request,TbUser tbUser){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String  strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        
        //封装分页插件DataTables结果
        PageInfo<TbUser> pageInfo = tbUserService.page(draw, start, length,tbUser);
        return pageInfo;
    }

    /**
     * 显示用户详情
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbUser tbUser){
        System.out.println(tbUser.getUsername());
        return "user_detail";
    }
}
