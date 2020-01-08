package com.wufan.my.shop.domain;

import com.wufan.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * 内容管理
 * @author Kirsh
 * @date 2020/1/8 11:51
 */
@Data
public class TbContent extends BaseEntity {
   private Long categoryId;
   private String title;
   private String subTitle;
   private String titleDesc;
   private String url;
   private String pic;
   private String pic2;
   private String content;
}
