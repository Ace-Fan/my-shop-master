package com.wufan.my.shop.web.admin.service.impl;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.domain.TbContent;
import com.wufan.my.shop.domain.TbContentCategory;
import com.wufan.my.shop.web.admin.dao.TbContentCategoryDao;
import com.wufan.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }

    public BaseResult save(TbContentCategory tbContentCategory) {
        //通过验证
        BaseResult baseResult = checkTbContentCategory(tbContentCategory);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            tbContentCategory.setUpdated(new Date());

            tbContentCategory.setUpdated(new Date());
            //新增内容
            if (tbContentCategory.getId() == null){
                tbContentCategory.setCreated(new Date());
                tbContentCategoryDao.insert(tbContentCategory);
            }
            //编辑用户
            else {
                tbContentCategoryDao.update(tbContentCategory);
            }
            baseResult.setMessage("保存内容信息成功");
        }
        return baseResult;
    }

    @Override
    public TbContentCategory getById(Long id) {
        return tbContentCategoryDao.getById(id);
    }

    /**
     *内容信息的有效性验证
     * @param tbContentCategory
     */
    private BaseResult checkTbContentCategory(TbContentCategory tbContentCategory){
        BaseResult baseResult = BaseResult.success();
        //非空验证
        if (tbContentCategory.getParentId() == null){
            baseResult = BaseResult.fail("父级类目不为空，请重新输入");
        }
        else if (tbContentCategory.getName()== null){
            baseResult = BaseResult.fail("分类名称不为空，请重新输入");
        }
        else  if (tbContentCategory.getSortOrder() == null){
            baseResult = BaseResult.fail("分类排序不为空，请重新输入");
        }
        return  baseResult;
    }
}
