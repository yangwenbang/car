package com.car.vo;

import java.io.Serializable;

public class UserVO implements Serializable {

	private static final long serialVersionUID = 7547555237125420315L;
	
	private long userId;
	private String mobile;
	private String userName;
	private int sex;
	private String homeAddress;
	private String email;
	private String cityName;
	private String softVersion;
	private String userPicture;
	private Integer openSmsRemind;
	private String token;
	private Long expire;
	private Long projectId;
	private Long categoryId;
	private String projectName;	
	private String categoryName;
	private Long cityId;
	private String organCode;
	private String organPicture;
	private String organName;
	private String userCode;
	private String askUrl;
	private String openid;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName == null ? "" : userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getHomeAddress() {
		return homeAddress == null ? "" : homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getEmail() {
		return email == null ? "" : email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCityName() {
		return cityName == null ? "" : cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getSoftVersion() {
		return softVersion == null ? "" : softVersion;
	}

	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}

	public String getUserPicture() {
		return userPicture == null ? "" : userPicture;
	}

	public Integer getOpenSmsRemind() {
		return openSmsRemind == null ? 0 : openSmsRemind;
	}

	public void setOpenSmsRemind(Integer openSmsRemind) {
		this.openSmsRemind = openSmsRemind;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getExpire() {
		return expire == null ? 0 : expire;
	}

	public void setExpire(Long expire) {
		this.expire = expire;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getCityId() {
		return cityId == null ? 0 : cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getOrganCode() {
		return organCode == null ? "" : organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganPicture() {
		return organPicture == null ? "" : organPicture;
	}

	public void setOrganPicture(String organPicture) {
		this.organPicture = organPicture;
	}

	public String getOrganName() {
		return organName == null ? "" : organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getAskUrl() {
		return askUrl;
	}

	public void setAskUrl(String askUrl) {
		this.askUrl = askUrl;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}