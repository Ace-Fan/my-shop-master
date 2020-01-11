package com.wufan.my.shop.web.admin.service.impl;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.validator.BeanValidator;
import com.wufan.my.shop.domain.TbContentCategory;
import com.wufan.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import com.wufan.my.shop.web.admin.dao.TbContentCategoryDao;
import com.wufan.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Kirsh
 * @date 2020/1/7 20:47
 */

@Service
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory,TbContentCategoryDao> implements TbContentCategoryService {

    @Override
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
                dao.insert(entity);
            }

            // 修改
            else {
                update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }
}
