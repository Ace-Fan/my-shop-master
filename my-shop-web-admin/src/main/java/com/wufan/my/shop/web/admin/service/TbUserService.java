package com.wufan.my.shop.web.admin.service;

import com.wufan.my.shop.commons.dto.BaseResult;
import com.wufan.my.shop.commons.dto.PageInfo;
import com.wufan.my.shop.domain.TbUser;


import java.util.List;

public interface TbUserService {

    /**
     * 查询所有
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 保存用户信息
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据Id获取用户信息
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 更新用户信息
     * @param tbUser
     */
    void  update(TbUser tbUser);

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<TbUser> page(int draw,int start, int length,TbUser tbUser);

    /**
     * 查询总记录数
     * @return
     */
    int count(TbUser tbUser);
}
