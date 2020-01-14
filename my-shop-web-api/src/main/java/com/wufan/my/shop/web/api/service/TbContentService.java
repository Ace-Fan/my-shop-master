package com.wufan.my.shop.web.api.service;

import com.wufan.my.shop.domain.TbContent;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/14 14:34
 */

public interface TbContentService {
    /**
     * 根据类别ID查询内容列表
     * @param categoryId
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryId);
}
