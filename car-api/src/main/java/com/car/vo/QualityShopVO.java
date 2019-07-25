package com.car.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * wind
 */
@ApiModel("质检商家")
public class QualityShopVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "质检商家ID")
	private Long qualityShopId;
	
	@ApiModelProperty(value = "商店名称")
	private String shopName;

	@ApiModelProperty(value = "商店描述")
	private String description;
	
	@ApiModelProperty(value = "商店图片")
	private String shopPicture;
	
	@ApiModelProperty(value = "营业时间")
	private String businessTime;
	
	@ApiModelProperty(value = "商店地址(省，市，区)")
	private String address;
	
	@ApiModelProperty(value = "详情地址")
	private String detailAddress;
	
	@ApiModelProperty(value = "经度")
	private String longitude;

	@ApiModelProperty(value = "纬度")
	private String latitude;
	
	
	public Long getQualityShopId() {
		return qualityShopId;
	}
	
	public void setQualityShopId(Long qualityShopId) {
		this.qualityShopId = qualityShopId;
	}
	/**
	 * 设置：商店名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：商店名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：商店描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：商店描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：商店图片
	 */
	public void setShopPicture(String shopPicture) {
		this.shopPicture = shopPicture;
	}
	/**
	 * 获取：商店图片
	 */
	public String getShopPicture() {
		return shopPicture;
	}
	/**
	 * 设置：营业时间
	 */
	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}
	/**
	 * 获取：营业时间
	 */
	public String getBusinessTime() {
		return businessTime;
	}
	/**
	 * 设置：商店地址(省，市，区)
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：商店地址(省，市，区)
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
	
}
