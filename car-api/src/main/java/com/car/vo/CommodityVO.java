package com.car.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("商品对象")
public class CommodityVO implements Serializable {

    @ApiModelProperty(value = "商品ID")
    private Long commodityId;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "商品图片，多个用逗号隔开")
    private String commodityPicture;

    @ApiModelProperty(value = "商品描述")
    private String description;

    @ApiModelProperty(value = "商品类型(0新商品/1二手商品)")
    private Integer commodityType;

    @ApiModelProperty(value = "商品使用开始时间")
    private String useStartTime;

    @ApiModelProperty(value = "商品使用结束时间")
    private String useEndTime;

    @ApiModelProperty(value = "使用状况")
    private String useState;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "交易方式(0同城面交/1邮寄)")
    private Integer tradeMode;

    @ApiModelProperty(value = "商品品牌")
    private String brand;

    @ApiModelProperty(value = "商品型号")
    private String model;

    @ApiModelProperty(value = "商品颜色")
    private String color;

    @ApiModelProperty(value = "商品材料")
    private String material;

    @ApiModelProperty(value = "有无瑕疵（0没有,1有）")
    private Integer haveFlaw;

    @ApiModelProperty(value = "轮胎胎宽,扁平比和直径(165-20-R14)")
    private String tyreSize;

    @ApiModelProperty(value = "孔距(100-4)")
    private String holeSpacing;

    @ApiModelProperty(value = "制造方式(单片锻造0,双片锻造1，三片锻造2)")
    private Integer manufacturMode;

    @ApiModelProperty(value = "光源类型")
    private String lightType;

    @ApiModelProperty(value = "轮毂J值和直径（6,。9J-16）")
    private String hubSize;

    @ApiModelProperty(value = "尺寸")
    private String size;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "瑕疵内容")
    private String flaw;

    @ApiModelProperty(value = "部位（整体0,前段1,中段2,中后3,后段4）")
    private Integer position;

    @ApiModelProperty(value = "入手价")
    private BigDecimal start_price;

    @ApiModelProperty(value = "运费")
    private BigDecimal freight;

    @ApiModelProperty(value = "商品发布人名")
    private String publishUserName;

    @ApiModelProperty(value = "商品发布人头像地址")
    private String publishUserHead;

    @ApiModelProperty(value = "其他分类名称")
    private String otherCategoryName;

    @ApiModelProperty(value = "具体描述")
    private String concreteDescription;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getHaveFlaw() {
        return haveFlaw;
    }

    public void setHaveFlaw(Integer haveFlaw) {
        this.haveFlaw = haveFlaw;
    }

    public String getTyreSize() {
        return tyreSize;
    }

    public void setTyreSize(String tyreSize) {
        this.tyreSize = tyreSize;
    }

    public String getHoleSpacing() {
        return holeSpacing;
    }

    public void setHoleSpacing(String holeSpacing) {
        this.holeSpacing = holeSpacing;
    }

    public Integer getManufacturMode() {
        return manufacturMode;
    }

    public void setManufacturMode(Integer manufacturMode) {
        this.manufacturMode = manufacturMode;
    }

    public String getLightType() {
        return lightType;
    }

    public void setLightType(String lightType) {
        this.lightType = lightType;
    }

    public String getHubSize() {
        return hubSize;
    }

    public void setHubSize(String hubSize) {
        this.hubSize = hubSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlaw() {
        return flaw;
    }

    public void setFlaw(String flaw) {
        this.flaw = flaw;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
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

    public Integer getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(Integer commodityType) {
        this.commodityType = commodityType;
    }

    public String getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(String useStartTime) {
        this.useStartTime = useStartTime;
    }

    public String getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(String useEndTime) {
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

    public Integer getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(Integer tradeMode) {
        this.tradeMode = tradeMode;
    }

    public BigDecimal getStart_price() {
        return start_price;
    }

    public void setStart_price(BigDecimal start_price) {
        this.start_price = start_price;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getPublishUserName() {
        return publishUserName;
    }

    public void setPublishUserName(String publishUserName) {
        this.publishUserName = publishUserName;
    }

    public String getPublishUserHead() {
        return publishUserHead;
    }

    public void setPublishUserHead(String publishUserHead) {
        this.publishUserHead = publishUserHead;
    }

    public String getOtherCategoryName() {
        return otherCategoryName;
    }

    public void setOtherCategoryName(String otherCategoryName) {
        this.otherCategoryName = otherCategoryName;
    }

    public String getConcreteDescription() {
        return concreteDescription;
    }

    public void setConcreteDescription(String concreteDescription) {
        this.concreteDescription = concreteDescription;
    }
}
