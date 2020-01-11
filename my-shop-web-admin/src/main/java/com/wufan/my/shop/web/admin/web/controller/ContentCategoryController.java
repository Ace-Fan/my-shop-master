package com.wufan.my.shop.web.admin.web.controller;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.domain.TbContentCategory;
import com.wufan.my.shop.web.admin.abstracts.AbstractBaseTreeController;
import com.wufan.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类管理
 * @author Kirsh
 * @date 2020/1/7 20:48
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController extends AbstractBaseTreeController<TbContentCategory,TbContentCategoryService> {

    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id){
        TbContentCategory tbContentCategory = null;

        //id 不为空，从数据库获取
        if (id != null){
            tbContentCategory = service.getById(id);
        }
        else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = service.selectAll();

        //排序
        sortList(sourceList,targetList,0L);
        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }

    /**
     * 跳转表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(TbContentCategory tbContentCategory) {
        return "content_category_form";
    }
    /**
     * 保存内容分类信息
     * @param tbContentCategory
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.save(tbContentCategory);

        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/category/list";
        } else {
            model.addAttribute("baseResult", baseResult);
            return form(tbContentCategory);
        }
    }
    /**
     * 树形结构
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree/data",method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id){
        if(id == null){
            id = 0L;
        }
        return service.selectByPid(id);
    }
}
