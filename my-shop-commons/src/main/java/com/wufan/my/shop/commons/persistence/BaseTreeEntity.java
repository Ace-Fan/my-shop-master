package com.wufan.my.shop.commons.persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Kirsh
 * @date 2020/1/11 16:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
