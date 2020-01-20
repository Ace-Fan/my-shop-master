package com.wufan.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Kirsh
 * @date 2020/1/15 19:40
 */
@Data
public class TbContent implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
