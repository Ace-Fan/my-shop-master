package com.wufan.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Kirsh
 * @date 2020/1/16 11:34
 */
@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;
}
