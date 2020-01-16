package com.wufan.my.shop.web.api.service.impl;

import com.wufan.my.shop.domain.TbUser;
import com.wufan.my.shop.web.api.dao.TbUserDao;
import com.wufan.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author Kirsh
 * @date 2020/1/16 10:42
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);

        if(user != null){
            //明文密码加密
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if (password.equals(user.getPassword())){
                return user;
            }
        }

        return null;
    }
}
