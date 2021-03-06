package com.wufan.my.shop.web.admin.service.impl;


import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.validator.BeanValidator;
import com.wufan.my.shop.domain.TbContent;
import com.wufan.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.wufan.my.shop.web.admin.dao.TbContentDao;
import com.wufan.my.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author Kirsh
 * @date 2020/1/8 13:52
 */
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent,TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //验证不通过
        if(validator !=null){
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            tbContent.setUpdated(new Date());
            //新增用户
            if (tbContent.getId() == null){
                //密码加密处理
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }
            //编辑用户
            else {
                update(tbContent);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }
}
