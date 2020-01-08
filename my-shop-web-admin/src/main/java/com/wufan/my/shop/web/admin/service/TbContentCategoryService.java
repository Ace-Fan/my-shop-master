package com.wufan.my.shop.web.admin.service;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.domain.TbContent;
import com.wufan.my.shop.domain.TbContentCategory;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/7 20:46
 */
public interface TbContentCategoryService {
    List<TbContentCategory> selectAll();
    /**
     * 根据父级节点ID查询所有节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
    /**
     * 新增
     * @param tbContentCategory
     */
    BaseResult save(TbContentCategory tbContentCategory);
    /**
     * 根据id查询内容信息
     * @param id
     * @return
     */

    TbContentCategory getById(Long id);
}
