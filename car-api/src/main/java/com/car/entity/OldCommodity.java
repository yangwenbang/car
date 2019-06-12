package com.car.entity;


import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author lzp
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 21:33:04
 */
public class OldCommodity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品ID
	 */
	private Long id;
	/**
	 * 商品分类ID
	 */
	private Long commodityCategoryId;
	/**
	 * 商品名称
	 */
	private String commodityName;
	/**
	 * 商品图片，多个用逗号隔开
	 */
	private String commodityPicture;
	/**
	 * 商品描述
	 */
	private String description;
	/**
	 * 商品使用开始时间
	 */
	private Date useStartTime;
	/**
	 * 商品使用结束时间
	 */
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
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 商品品牌
	 */
	private String brand;
	/**
	 * 商品型号
	 */
	private String model;
	/**
	 * 商品颜色
	 */
	private String color;
	/**
	 * 商品材料
	 */
	private String material;
	/**
	 * 有无瑕疵（0没有,1有）
	 */
	private Integer haveFlaw;
	/**
	 * 轮胎胎宽,扁平比和直径(165-20-R14)
	 */
	private String tyreSize;
	/**
	 * 孔距(100-4)
	 */
	private String holeSpacing;
	/**
	 * 制造方式(单片锻造0,双片锻造1，三片锻造2)
	 */
	private Integer manufacturMode;
	/**
	 * 光源类型
	 */
	private String lightType;
	/**
	 * 轮毂J值和直径（6,。9J-16）
	 */
	private String hubSize;
	/**
	 * 尺寸
	 */
	private String size;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 瑕疵内容
	 */
	private String flaw;
	/**
	 * 部位（整体0,前段1,中段2,中后3,后段4）
	 */
	private Integer position;
	/**
	 * 商品数量
	 */
	private Integer commodityNum;

	private BigDecimal startPrice;

	private BigDecimal freight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

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

	public Integer getCommodityNum() {
		return commodityNum;
	}

	public void setCommodityNum(Integer commodityNum) {
		this.commodityNum = commodityNum;
	}

	public BigDecimal getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(BigDecimal startPrice) {
		this.startPrice = startPrice;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}
}
