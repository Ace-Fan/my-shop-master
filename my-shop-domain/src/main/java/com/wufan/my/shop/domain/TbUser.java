package com.wufan.my.shop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wufan.my.shop.commons.persistence.BaseEntity;
import com.wufan.my.shop.commons.utils.RegexpUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;


/**
 * @author ：WuFan
 * @date ：Created in 2019/11/17 0017 23:13
 * @description：
 * @modified By：
 * @version: $
 */

@Data
public class TbUser extends BaseEntity {
    @Length(min = 2,max = 12,message = "用户名长度必须介于2-12位之间")
         private String username;
         @JsonIgnore
         @Length(min = 6,max = 12,message = "密码长度必须介于6-12位之间")
         private String password;
         @Pattern(regexp = RegexpUtils.PHONE,message = "手机号格式不正确")
         private String phone;
         @Pattern(regexp = RegexpUtils.EMAIL,message = "邮箱格式不正确")
         private String email;
}
