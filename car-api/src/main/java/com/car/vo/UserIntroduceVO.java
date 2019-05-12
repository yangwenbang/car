package com.car.vo;

import java.io.Serializable;

public class UserIntroduceVO implements Serializable {

	private static final long serialVersionUID = -4005752627554553235L;

	private Long userIntroduceId;
	private Long userId;
	private Long offlineOrganizationId;
	private String openid;
	private String organizationCode;
	private String organizationName;
	private String organizationPicture;

	public Long getUserIntroduceId() {
		return userIntroduceId;
	}

	public void setUserIntroduceId(Long userIntroduceId) {
		this.userIntroduceId = userIntroduceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOfflineOrganizationId() {
		return offlineOrganizationId;
	}

	public void setOfflineOrganizationId(Long offlineOrganizationId) {
		this.offlineOrganizationId = offlineOrganizationId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationPicture() {
		return organizationPicture;
	}

	public void setOrganizationPicture(String organizationPicture) {
		this.organizationPicture = organizationPicture;
	}

}