package com.wufan.my.shop.web.admin.dao;

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
}
