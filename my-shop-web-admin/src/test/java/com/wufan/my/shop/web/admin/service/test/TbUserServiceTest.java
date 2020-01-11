package com.wufan.my.shop.web.admin.service.test;

import com.wufan.my.shop.domain.TbUser;
import com.wufan.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author ：WuFan
 * @date ：Created in 2019/11/18 0018 22:08
 * @description：
 * @modified By：
 * @version: $
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
@MapperScan(value = {"mapper"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public  void testSelectAll(){
        List<TbUser> tbUsers = tbUserService.selectAll();
        for(TbUser tbUser:tbUsers){
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testInsert(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("Wufan");
        tbUser.setPhone("17673240903");
        tbUser.setEmail("wufan@wufan.com");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserService.save(tbUser);
    }

    @Test
    public void testMd5(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }

    @Test
    public  void  testDelete(){
        tbUserService.delete(38L);
    }

    @Test
    public  void testGetById(){
        TbUser tbUser = tbUserService.getById(37L);
        System.out.println(tbUser.getUsername());
    }
    @Test
    public void testUpdate(){
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("WuFan");
        tbUserService.update(tbUser);
    }


}
