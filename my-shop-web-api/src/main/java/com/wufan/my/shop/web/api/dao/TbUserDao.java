package com.wufan.my.shop.web.api.dao;

import com.wufan.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 * @author Kirsh
 * @date 2020/1/16 10:31
 */
@Repository
public interface TbUserDao {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
