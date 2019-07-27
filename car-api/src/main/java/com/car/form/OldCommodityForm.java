package com.car.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "二手商品表单")
public class OldCommodityForm {

	@ApiModelProperty(value = "商品分类ID", required = true)
	@NotBlank(message = "分类不能为空")
	private Long commodityCategoryId;

	@ApiModelProperty(value = "质检商家ID", required = true)
	private Long qualityShopId;
	
	@ApiModelProperty(value = "商品发布人(当前登录人)", required = true)
	private Long publishUserId;

	@ApiModelProperty(value = "商品名称", required = true)
	@NotBlank(message = "商品名称不能为空")
	private String commodityName;

	@ApiModelProperty(value = "商品描述")
	private String description;

	@ApiModelProperty(value = "商品图片，多个用逗号隔开")
	private String commodityPicture;

	@ApiModelProperty(value = "购入时间(年月)")
	private String useTimeLength;

	@ApiModelProperty(value = "商品价格")
	private Double price;

	@ApiModelProperty(value = "商品发布地址(省，市，区)")
	private String address;
	
	@ApiModelProperty(value = "详情地址")
	private String detailAddress;
	
	@ApiModelProperty(value = "经度")
	private String longitude;
	
	@ApiModelProperty(value = "纬度")
	private String latitude;
	
	@ApiModelProperty(value = "寄卖费")
	private Double consignmentPrice;
	
	@ApiModelProperty(value = "运费")
	private Double freight;

	@ApiModelProperty(value = "到店时间")
	private Date arrivalTime;

	public Long getCommodityCategoryId() {
		return commodityCategoryId;
	}

	public void setCommodityCategoryId(Long commodityCategoryId) {
		this.commodityCategoryId = commodityCategoryId;
	}

	public Long getQualityShopId() {
		return qualityShopId;
	}

	public void setQualityShopId(Long qualityShopId) {
		this.qualityShopId = qualityShopId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCommodityPicture() {
		return commodityPicture;
	}

	public void setCommodityPicture(String commodityPicture) {
		this.commodityPicture = commodityPicture;
	}

	public String getUseTimeLength() {
		return useTimeLength;
	}

	public void setUseTimeLength(String useTimeLength) {
		this.useTimeLength = useTimeLength;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Double getConsignmentPrice() {
		return consignmentPrice;
	}

	public void setConsignmentPrice(Double consignmentPrice) {
		this.consignmentPrice = consignmentPrice;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	

}
