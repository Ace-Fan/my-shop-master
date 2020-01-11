package com.wufan.my.shop.web.admin.service;

import com.wufan.my.shop.commons.persistence.BaseService;
import com.wufan.my.shop.domain.TbContentCategory;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/7 20:46
 */
public interface TbContentCategoryService extends BaseService<TbContentCategory> {
    /**
     * 根据父级节点ID查询所有节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
