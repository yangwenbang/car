package com.car.vo;

import java.io.Serializable;

public class CityVO implements Serializable {

	private static final long serialVersionUID = 4157407683956150917L;
	
	private Long cityId;
	private Long provinceId;
	private String cityName;
	private String cityAddress;
	private String cityTelephone;
	private String remark;
	private String provinceName;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public String getCityTelephone() {
		return cityTelephone;
	}

	public void setCityTelephone(String cityTelephone) {
		this.cityTelephone = cityTelephone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}