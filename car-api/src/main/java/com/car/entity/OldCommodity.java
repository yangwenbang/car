package com.car.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @author lzp
 */
public class OldCommodity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long qualityShopId;
	private Long commodityCategoryId;

	/**
	 * 商品名称
	 */
	private String commodityName;
	/**
	 * 商品单号(规则：0100 + 商品数量递增)
	 */
	private String commodityCode;
	/**
	 * 商品图片，多个用逗号隔开
	 */
	private String commodityPicture;
	/**
	 * 商品描述
	 */
	private String description;
	/**
	 * 使用时长(单位是年)
	 */
	private String useTimeLength;
	/**
	 * 商品价格
	 */
	private Double price;
	/**
	 * 商品发布人
	 */
	private Long publishUserId;
	/**
	 * 商品发布地址(省，市，区)
	 */
	private String address;
	/**
	 * 详情地址
	 */
	private String detailAddress;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitude;
	/**
	 * 寄卖费
	 */
	private Double consignmentPrice;
	/**
	 * 运费
	 */
	private Double freight;
	/**
	 * 到店时间
	 */
	private Date arrivalTime;
	/**
	 * 审核状态(0未审核/1已通过/2已拒绝)
	 */
	private Integer auditStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

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
	 * 设置：商品单号(规则：0100 + 商品数量递增)
	 */
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}
	/**
	 * 获取：商品单号(规则：0100 + 商品数量递增)
	 */
	public String getCommodityCode() {
		return commodityCode;
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
	 * 设置：使用时长(单位是年)
	 */
	public void setUseTimeLength(String useTimeLength) {
		this.useTimeLength = useTimeLength;
	}
	/**
	 * 获取：使用时长(单位是年)
	 */
	public String getUseTimeLength() {
		return useTimeLength;
	}
	/**
	 * 设置：商品价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：商品价格
	 */
	public Double getPrice() {
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
	 * 设置：商品发布地址(省，市，区)
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：商品发布地址(省，市，区)
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：详情地址
	 */
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	/**
	 * 获取：详情地址
	 */
	public String getDetailAddress() {
		return detailAddress;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：寄卖费
	 */
	public void setConsignmentPrice(Double consignmentPrice) {
		this.consignmentPrice = consignmentPrice;
	}
	/**
	 * 获取：寄卖费
	 */
	public Double getConsignmentPrice() {
		return consignmentPrice;
	}
	/**
	 * 设置：运费
	 */
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	/**
	 * 获取：运费
	 */
	public Double getFreight() {
		return freight;
	}
	/**
	 * 设置：到店时间
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * 获取：到店时间
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * 设置：审核状态(0未审核/1已通过/2已拒绝)
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态(0未审核/1已通过/2已拒绝)
	 */
	public Integer getAuditStatus() {
		return auditStatus;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQualityShopId() {
		return qualityShopId;
	}
	public void setQualityShopId(Long qualityShopId) {
		this.qualityShopId = qualityShopId;
	}
	public Long getCommodityCategoryId() {
		return commodityCategoryId;
	}
	public void setCommodityCategoryId(Long commodityCategoryId) {
		this.commodityCategoryId = commodityCategoryId;
	}
}
