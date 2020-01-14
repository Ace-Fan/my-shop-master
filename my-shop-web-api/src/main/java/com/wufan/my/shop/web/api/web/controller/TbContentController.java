package com.wufan.my.shop.web.api.web.controller;

import com.wufan.my.shop.domain.TbContent;
import com.wufan.my.shop.web.api.service.TbContentService;
import com.wufan.my.shop.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/14 14:40
 */
@RestController
@RequestMapping(value = "content")
public class TbContentController  {

    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        if (id == null) {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    @RequestMapping(value = "findContentByCategoryId",method = RequestMethod.GET)
    public List<TbContentDTO> findContentByCategoryId(Long categoryId){
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(categoryId);

        if (tbContents != null && tbContents.size() > 0) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO dto = new TbContentDTO();
                BeanUtils.copyProperties(tbContent, dto);
                tbContentDTOS.add(dto);
            }
        }
        return tbContentDTOS;
    }
}
