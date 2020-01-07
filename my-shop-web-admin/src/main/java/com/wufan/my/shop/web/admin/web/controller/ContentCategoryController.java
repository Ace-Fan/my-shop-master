package com.wufan.my.shop.web.admin.web.controller;

import com.wufan.my.shop.domain.TbContentCategory;
import com.wufan.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 内容分类管理
 * @author Kirsh
 * @date 2020/1/7 20:48
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> tbContentCategories = tbContentCategoryService.selectAll();
        model.addAttribute("tbContentCategories",tbContentCategories);
        return "content_category_list";
    }
}
