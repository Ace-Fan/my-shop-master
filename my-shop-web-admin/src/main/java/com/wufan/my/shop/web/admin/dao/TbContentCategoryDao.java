package com.wufan.my.shop.web.admin.dao;

import com.wufan.my.shop.domain.TbContent;
import com.wufan.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/7 20:43
 */
@Repository
public interface TbContentCategoryDao {
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
    void insert(TbContentCategory tbContentCategory);
    /**
     * 更新
     * @param tbContentCategory
     */
    void  update(TbContentCategory tbContentCategory);
    /**
     * 根据id查询内容信息
     * @param id
     * @return
     */

    TbContentCategory getById(Long id);


}
