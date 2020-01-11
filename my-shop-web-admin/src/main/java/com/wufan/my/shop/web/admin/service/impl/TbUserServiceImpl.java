package com.wufan.my.shop.web.admin.service.impl;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.validator.BeanValidator;
import com.wufan.my.shop.domain.TbUser;
import com.wufan.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.wufan.my.shop.web.admin.dao.TbUserDao;
import com.wufan.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @author ：WuFan
 * @date ：Created in 2019/11/19 0019 21:33
 * @description：
 * @modified By：
 * @version: $
 */

@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser,TbUserDao> implements TbUserService{


    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        //验证不通过
        if(validator !=null){
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            tbUser.setUpdated(new Date());
            //新增用户
            if (tbUser.getId() == null){
                //密码加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                dao.insert(tbUser);
            }
            //编辑用户
            else {
                update(tbUser);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.getByEmail(email);

        if(tbUser !=null){
            //明文加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //判断加密后密码与数据库存放密码是否匹配，匹配则登录
            if(md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }

        return null;
    }
}
