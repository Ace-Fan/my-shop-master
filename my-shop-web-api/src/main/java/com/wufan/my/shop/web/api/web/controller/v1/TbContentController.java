package com.wufan.my.shop.web.api.web.controller.v1;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.domain.TbContent;
import com.wufan.my.shop.web.api.service.TbContentService;
import com.wufan.my.shop.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/14 14:40
 */
@RestController
@RequestMapping(value = "${api.path.v1}/contents")
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

    /**
     * 根据类别id查询内容列表
     * @return
     */
    @RequestMapping(value = "ppt",method = RequestMethod.GET)
    public BaseResult findPPT(){
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(89L);

        if (tbContents != null && tbContents.size() > 0) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO dto = new TbContentDTO();
                BeanUtils.copyProperties(tbContent, dto);
                tbContentDTOS.add(dto);
            }
        }
        return BaseResult.success("成功",tbContentDTOS);
    }
}
