package com.wufan.my.shop.web.api.service;

import com.wufan.my.shop.domain.TbUser;

/**
 * 会员guan'l
 * @author Kirsh
 * @date 2020/1/16 10:41
 */
public interface TbUserService {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
