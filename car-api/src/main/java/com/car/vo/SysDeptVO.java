package com.car.vo;

import java.io.Serializable;

public class SysDeptVO implements Serializable {

	private static final long serialVersionUID = -5699583674001396079L;

	private Long sysDeptId;
	private String name;
	private String address;
	private String contact;
	private String phone;
	private String description;
	private String picture;
	private String askUrl;

	public Long getSysDeptId() {
		return sysDeptId;
	}

	public void setSysDeptId(Long sysDeptId) {
		this.sysDeptId = sysDeptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAskUrl() {
		return askUrl;
	}

	public void setAskUrl(String askUrl) {
		this.askUrl = askUrl;
	}

}