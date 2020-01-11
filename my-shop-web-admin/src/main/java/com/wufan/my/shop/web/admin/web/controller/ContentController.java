package com.wufan.my.shop.web.admin.web.controller;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.dto.PageInfo;
import com.wufan.my.shop.domain.TbContent;
import com.wufan.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kirsh
 * @date 2020/1/8 14:56
 */
@Controller
@RequestMapping(value = "content")
public class ContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        //id 不为空，从数据库获取
        if (id != null){
            tbContent = tbContentService.getById(id);
        }
        else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     * 跳转内容列表页
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "content_list";
    }

    /**
     * 跳转内容表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "content_form";
    }

    /**
     * 保存内容信息
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbContentService.save(tbContent);

        //保存成功
        if (baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult",baseResult);
            return "content_form";
        }
    }

    /**
     * 删除内容信息
     * @param ids
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(ids)){
            String [] idArray = ids.split(",");
            tbContentService.deleteMulti(idArray);
            baseResult = BaseResult.success("批量删除内容成功");
        }
        else {
            baseResult = BaseResult.fail("批量删除内容失败");
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
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String  strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装分页插件DataTables结果
        PageInfo<TbContent> pageInfo = tbContentService.page(draw, start, length,tbContent);

        return pageInfo;
    }

    /**
     * 显示用户详情
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent){
        return "content_detail";
    }  
}