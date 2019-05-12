package com.car.vo;

import java.io.Serializable;

public class UserDetailVO implements Serializable {

	private static final Long serialVersionUID = -8871929981954349276L;
	
	private Long userDetailId;
	private Long userId;
	private Long cityId;
	private Integer userType;
	private Long provinceId;
	private String cityName;
	private String education;
	private Integer buySmsRemind;
	private Integer openSmsRemind;
	private String provinceName;
	private String userPicture;
	private Integer equipmentType;
	private String equipmentModel;
	private String systemVersion;
	private String softVersion;
	private String accessToken;
	private String openid;
	private String userCode;
	private Long expiresIn;
	private Integer sex;
	private String organCode;
	private String organName;
	private String organPicture;
	private Long offlineOrganizationId;

	public Long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Long userDetailId) {
		this.userDetailId = userDetailId;
	}
	
	public Long getCityId() {
		return cityId == null ? 0 : cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	
	public Long getProvinceId() {
		return provinceId == null ? 0 : provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCityName() {
		return cityName == null ? "" : cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getEducation() {
		return this.education == null ? "" : education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Integer getBuySmsRemind() {
		return buySmsRemind == null ? 0 : buySmsRemind;
	}

	public void setBuySmsRemind(Integer buySmsRemind) {
		this.buySmsRemind = buySmsRemind;
	}

	public Integer getOpenSmsRemind() {
		return openSmsRemind == null ? 0 : openSmsRemind;
	}

	public void setOpenSmsRemind(Integer openSmsRemind) {
		this.openSmsRemind = openSmsRemind;
	}

	public String getProvinceName() {
		return provinceName == null ? "" : provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getUserType() {
		return userType == null ? 0 : userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserPicture() {
		return userPicture == null ? "" : userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public Integer getEquipmentType() {
		return equipmentType == null ? 0 : equipmentType;
	}

	public void setEquipmentType(Integer equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentModel() {
		return equipmentModel == null ? "" : equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String getSystemVersion() {
		return systemVersion == null ? "" : systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getSoftVersion() {
		return softVersion == null ? "" : softVersion;
	}

	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}

	public String getAccessToken() {
		return accessToken == null ? "" : accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getOpenid() {
		return openid == null ? "" : openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Long getExpiresIn() {
		return expiresIn == null ? 0 : expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Integer getSex() {
		return sex == null ? 0 : sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getUserCode() {
		return userCode == null ? "" : userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getOrganCode() {
		return organCode == null ? "" : organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return organName == null ? "" : organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getOrganPicture() {
		return organPicture == null ? "" : organPicture;
	}

	public void setOrganPicture(String organPicture) {
		this.organPicture = organPicture;
	}

	public Long getOfflineOrganizationId() {
		return offlineOrganizationId == null ? 0 : offlineOrganizationId;
	}

	public void setOfflineOrganizationId(Long offlineOrganizationId) {
		this.offlineOrganizationId = offlineOrganizationId;
	}
	
}