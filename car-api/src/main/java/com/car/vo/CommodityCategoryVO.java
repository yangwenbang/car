package com.car.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel("产品分类对象")
public class CommodityCategoryVO implements Serializable {

    @ApiModelProperty(value = "商品分类ID")
    private Long commodityCategoryId;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    public Long getId() {
        return commodityCategoryId;
    }

    public void setId(Long commodityCategoryId) {
        this.commodityCategoryId = commodityCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
