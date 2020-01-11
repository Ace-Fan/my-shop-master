package com.wufan.my.shop.commons.persistence;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 * @author Kirsh
 * @date 2020/1/10 11:33
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 查询所有数据
     * @return
     */
    public List<T> selectAll();

    /**
     * 保存数据
     * @param entity
     * @return
     */
    BaseResult save(T entity);

    /**
     * 删除数据
     * @param id
     */
    void delete(Long id);

    /**
     * 根据Id获取数据
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新数据
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
     * @param start
     * @param length
     * @return
     */
    PageInfo<T> page(int draw, int start, int length, T entity);

    /**
     * 查询总记录数
     * @return
     */
    int count(T entity);
}
