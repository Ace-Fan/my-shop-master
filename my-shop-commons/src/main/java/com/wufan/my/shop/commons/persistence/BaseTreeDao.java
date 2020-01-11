package com.wufan.my.shop.commons.persistence;

import java.util.List;

/**
 * 通用的树形结构数据访问接口
 * @author Kirsh
 * @date 2020/1/11 10:45
 */
public interface BaseTreeDao<T extends BaseEntity> {
    /**
     * 查询全部数据
     * @return
     */
    List<T> selectAll();

    /**
     * 新增
     * @param entity
     */
    void insert(T entity);

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
