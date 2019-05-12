package com.car.vo;

import java.io.Serializable;

public class ProvinceVO implements Serializable {

	private static final Long serialVersionUID = 7657917765879802698L;
	
	private Long provinceId;
	private String provinceName;
	private String companyAddress;
	private String contactWay;
	
	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getContactWay() {
		return this.contactWay;
	}
	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

}