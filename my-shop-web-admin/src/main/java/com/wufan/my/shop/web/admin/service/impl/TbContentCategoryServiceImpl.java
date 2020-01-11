package com.wufan.my.shop.web.admin.service.impl;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.dto.PageInfo;
import com.wufan.my.shop.commons.validator.BeanValidator;
import com.wufan.my.shop.domain.TbContentCategory;
import com.wufan.my.shop.web.admin.dao.TbContentCategoryDao;
import com.wufan.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kirsh
 * @date 2020/1/7 20:47
 */

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

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

    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if (validator != null) {
            return BaseResult.fail(validator);
        } else {
            TbContentCategory parent = entity.getParent();
            // 如果没有选择父级节点则默认设置为根目录
            if (parent == null || parent.getId() == null) {
                // 0 代表根目录
                parent.setId(0L);
            }

            entity.setUpdated(new Date());
            // 新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                entity.setIsParent(false);

                // 判断当前新增的节点有没有父级节点
                if (parent.getId() != 0L) {
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if (currentCategoryParent != null) {
                        // 为父级节点设置 isParent 为 true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }

                // 父级节点为 0 ，表示为根目录
                else {
                    // 根目录一定是父级目录
                    entity.setIsParent(true);
                }
                tbContentCategoryDao.insert(entity);
            }

            // 修改
            else {
                tbContentCategoryDao.update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }

    @Override
    public void delete(Long id) {
        tbContentCategoryDao.delete(id);
    }

    @Override
    public TbContentCategory getById(Long id) {
        return tbContentCategoryDao.getById(id);
    }

    @Override
    public void update(TbContentCategory entity) {
        tbContentCategoryDao.update(entity);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentCategoryDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbContentCategory> page(int draw, int start, int length, TbContentCategory entity) {
        int count = tbContentCategoryDao.count(entity);
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("tbContent",entity);
        PageInfo<TbContentCategory> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContentCategoryDao.page(params));
        return pageInfo;
    }

    @Override
    public int count(TbContentCategory entity) {
        return tbContentCategoryDao.count(entity);
    }

}
