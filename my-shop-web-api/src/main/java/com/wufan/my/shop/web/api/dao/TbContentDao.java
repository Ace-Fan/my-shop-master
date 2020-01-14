package com.wufan.my.shop.web.api.dao;

import com.wufan.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/14 14:21
 */
@Repository
public interface TbContentDao {
    /**
     * 根据类别ID查询内容列表
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
