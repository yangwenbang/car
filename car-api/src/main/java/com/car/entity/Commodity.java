package com.car.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

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
public class Commodity implements Serializable {
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
	 * 商品类型(0新商品/1二手商品)
	 */
	private Integer commodityType;
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
	 * 设置：商品ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：商品ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：商品分类ID
	 */
	public void setCommodityCategoryId(Long commodityCategoryId) {
		this.commodityCategoryId = commodityCategoryId;
	}
	/**
	 * 获取：商品分类ID
	 */
	public Long getCommodityCategoryId() {
		return commodityCategoryId;
	}
	/**
	 * 设置：商品名称
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getCommodityName() {
		return commodityName;
	}
	/**
	 * 设置：商品图片，多个用逗号隔开
	 */
	public void setCommodityPicture(String commodityPicture) {
		this.commodityPicture = commodityPicture;
	}
	/**
	 * 获取：商品图片，多个用逗号隔开
	 */
	public String getCommodityPicture() {
		return commodityPicture;
	}
	/**
	 * 设置：商品描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：商品描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：商品类型(0新商品/1二手商品)
	 */
	public void setCommodityType(Integer commodityType) {
		this.commodityType = commodityType;
	}
	/**
	 * 获取：商品类型(0新商品/1二手商品)
	 */
	public Integer getCommodityType() {
		return commodityType;
	}
	/**
	 * 设置：商品使用开始时间
	 */
	public void setUseStartTime(Date useStartTime) {
		this.useStartTime = useStartTime;
	}
	/**
	 * 获取：商品使用开始时间
	 */
	public Date getUseStartTime() {
		return useStartTime;
	}
	/**
	 * 设置：商品使用结束时间
	 */
	public void setUseEndTime(Date useEndTime) {
		this.useEndTime = useEndTime;
	}
	/**
	 * 获取：商品使用结束时间
	 */
	public Date getUseEndTime() {
		return useEndTime;
	}
	/**
	 * 设置：使用状况
	 */
	public void setUseState(String useState) {
		this.useState = useState;
	}
	/**
	 * 获取：使用状况
	 */
	public String getUseState() {
		return useState;
	}
	/**
	 * 设置：商品价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：商品价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：商品发布人
	 */
	public void setPublishUserId(Long publishUserId) {
		this.publishUserId = publishUserId;
	}
	/**
	 * 获取：商品发布人
	 */
	public Long getPublishUserId() {
		return publishUserId;
	}
	/**
	 * 设置：交易方式(0同城面交/1邮寄)
	 */
	public void setTradeMode(Integer tradeMode) {
		this.tradeMode = tradeMode;
	}
	/**
	 * 获取：交易方式(0同城面交/1邮寄)
	 */
	public Integer getTradeMode() {
		return tradeMode;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
