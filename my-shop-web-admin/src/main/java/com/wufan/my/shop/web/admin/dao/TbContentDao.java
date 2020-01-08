package com.wufan.my.shop.web.admin.dao;

import com.wufan.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Kirsh
 * @date 2020/1/8 13:50
 */
@Repository
public interface TbContentDao {
    /**
     * 查询内容表全部信息
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 新增
     * @param tbContent
     */
    void insert(TbContent tbContent);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询内容信息
     * @param id
     * @return
     */

    TbContent getById(Long id);

    /**
     * 更新
     * @param tbContent
     */
    void  update(TbContent tbContent);


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
    List<TbContent> page(Map<String,Object> params);

    /**
     * 查询总记录数
     * @return
     */
    int count(TbContent tbContent);
}
