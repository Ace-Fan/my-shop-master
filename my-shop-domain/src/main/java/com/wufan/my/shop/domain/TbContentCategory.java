package com.wufan.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wufan.my.shop.commons.persistence.BaseEntity;
import com.wufan.my.shop.commons.persistence.BaseService;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 内容分类管理
 * @author Kirsh
 * @date 2020/1/7 20:30
 */
@Data
public class TbContentCategory extends BaseEntity implements BaseService {
    private Long parentId;
    @Length(min = 1, max = 20, message = "分类名称必须介于 1 - 20 位之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;
    private TbContentCategory parent;
}
