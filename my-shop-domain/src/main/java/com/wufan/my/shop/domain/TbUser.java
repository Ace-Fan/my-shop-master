package com.wufan.my.shop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wufan.my.shop.commons.persistence.BaseEntity;
import lombok.Data;


/**
 * @author ：WuFan
 * @date ：Created in 2019/11/17 0017 23:13
 * @description：
 * @modified By：
 * @version: $
 */

@Data
public class TbUser extends BaseEntity {
         private String username;
         @JsonIgnore
         private String password;
         private String phone;
         private String email;
}
