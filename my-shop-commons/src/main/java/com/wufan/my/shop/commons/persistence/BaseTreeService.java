package com.wufan.my.shop.commons.persistence;

import com.wufan.my.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * 通用的树形结构业务接口
 * @author Kirsh
 * @date 2020/1/10 18:08
 */
public interface BaseTreeService<T extends BaseService>{
    /**
     * 查询全部数据
     * @return
     */
    List<T> selectAll();

    /**
     * 新增
     * @param entity
     */
    BaseResult save(T entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */

    T getById(Long id);

    /**
     * 更新
     * @param entity
     */
    void  update(T entity);

    /**
     * 根据父级节点ID查询所有节点
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);
}
