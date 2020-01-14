package com.wufan.my.shop.web.api.service.impl;

import com.wufan.my.shop.domain.TbContent;
import com.wufan.my.shop.domain.TbContentCategory;
import com.wufan.my.shop.web.api.dao.TbContentDao;
import com.wufan.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/14 14:36
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(categoryId);
        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        return tbContentDao.selectByCategoryId(tbContent);
    }
}
