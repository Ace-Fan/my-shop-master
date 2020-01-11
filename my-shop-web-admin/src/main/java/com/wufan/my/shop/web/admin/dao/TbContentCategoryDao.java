package com.wufan.my.shop.web.admin.dao;

import com.wufan.my.shop.commons.persistence.BaseDao;
import com.wufan.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/7 20:43
 */
@Repository
public interface TbContentCategoryDao extends BaseDao<TbContentCategory> {

    /**
     * 根据父级节点ID查询所有节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
