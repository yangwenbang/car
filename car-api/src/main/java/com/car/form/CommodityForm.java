package com.car.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "商品表单")
public class CommodityForm {
    @ApiModelProperty(value = "商品分类",required=true)
    @NotBlank(message = "分类不能为空")
    private Long commodityCategoryId;

    @ApiModelProperty(value = "商品名称",required=true)
    @NotBlank(message = "商品名称不能为空")
    private String commodityName;

    @ApiModelProperty(value = "商品描述")
    private String description;

    //@ApiModelProperty(value = "商品类型(0新商品/1二手商品)")
    //private Integer commodityType;

    @ApiModelProperty(value = "商品使用开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date useStartTime;

    @ApiModelProperty(value = "商品使用结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date useEndTime;

    @ApiModelProperty(value = "商品使用使用状况")
    private String useState;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品发布人",required=true)
    @NotBlank(message = "商品发布人为空")
    private Long publishUserId;

    @ApiModelProperty(value = "交易方式(0同城面交/1邮寄)")
    private Integer tradeMode;

    @ApiModelProperty(value = "商品图片，多个用逗号隔开")
    private String commodityPicture;

    public Long getCommodityCategoryId() {
        return commodityCategoryId;
    }

    public void setCommodityCategoryId(Long commodityCategoryId) {
        this.commodityCategoryId = commodityCategoryId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityPicture() {
        return commodityPicture;
    }

    public void setCommodityPicture(String commodityPicture) {
        this.commodityPicture = commodityPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    public String getUseState() {
        return useState;
    }

    public void setUseState(String useState) {
        this.useState = useState;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public Integer getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(Integer tradeMode) {
        this.tradeMode = tradeMode;
    }

}
