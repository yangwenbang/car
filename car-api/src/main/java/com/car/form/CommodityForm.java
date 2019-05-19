package com.car.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class CommodityForm {
    /**
     * 商品分类
     */
    private Long commodityCategoryId;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 商品类型(0新商品/1二手商品)
     */
    //private Integer commodityType;
    /**
     * 商品使用开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date useStartTime;
    /**
     * 商品使用结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date useEndTime;
    /**
     * 使用状况
     */
    private String useState;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 商品发布人
     */
    private Long publishUserId;
    /**
     * 交易方式(0同城面交/1邮寄)
     */
    private Integer tradeMode;
    /**
     * 商品图片，多个用逗号隔开
     */
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
