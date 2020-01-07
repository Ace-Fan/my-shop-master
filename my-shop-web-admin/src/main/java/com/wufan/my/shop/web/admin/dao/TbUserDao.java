package com.wufan.my.shop.web.admin.dao;

import com.wufan.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao {
    /**
     * 查询用户表全部信息
     * @return
     */
    List<TbUser> selectAll();

    /**
     * 新增
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */

    TbUser getById(Long id);

    /**
     * 更新
     * @param tbUser
     */
    void  update(TbUser tbUser);

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);


    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params 记录开始数和每页记录数
     * @return
     */
    List<TbUser> page(Map<String,Object> params);

    /**
     * 查询总记录数
     * @return
     */
    int count(TbUser tbUser);
}
