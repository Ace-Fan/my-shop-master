package com.wufan.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wufan.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * 内容分类管理
 * @author Kirsh
 * @date 2020/1/7 20:30
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;

}
