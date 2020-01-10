package com.wufan.my.shop.web.admin.service;

import com.wufan.my.shop.commons.persistence.BaseService;
import com.wufan.my.shop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {
    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);
}
