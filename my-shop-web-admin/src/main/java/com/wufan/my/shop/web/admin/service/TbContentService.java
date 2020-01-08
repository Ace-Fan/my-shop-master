package com.wufan.my.shop.web.admin.service;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.dto.PageInfo;
import com.wufan.my.shop.domain.TbContent;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/8 13:51
 */
public interface TbContentService {
    /**
     * 查询内容表全部信息
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 新增
     * @param tbContent
     */
    BaseResult save(TbContent tbContent);

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
     * @param draw
     * @param start
     * @param length
     * @param tbContent
     * @return
     */
    PageInfo<TbContent> page(int draw, int start, int length, TbContent tbContent);

    /**
     * 查询总记录数
     * @return
     */
    int count(TbContent tbContent);
}
