package com.wufan.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的基类
 * @author Kirsh
 * @date 2020/1/10 11:25
 */
public interface BaseDao<T extends BaseEntity> {
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
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params 记录开始数和每页记录数
     * @return
     */
    List<T> page(Map<String,Object> params);

    /**
     * 查询总记录数
     * @return
     */
    int count(T entity);
}
