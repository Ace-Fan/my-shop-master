package com.wufan.my.shop.web.admin.service.impl;

import com.wufan.my.shop.domain.TbContentCategory;
import com.wufan.my.shop.web.admin.dao.TbContentCategoryDao;
import com.wufan.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/7 20:47
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService{

    @Autowired
    private TbContentCategoryDao tbContentCategoryDao ;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }
}
