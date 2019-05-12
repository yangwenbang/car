package com.car.vo;

import java.io.Serializable;
import java.util.Date;

public class VipRecordVO implements Serializable {

	private static final long serialVersionUID = -2762367893485810391L;

	private Long vipRecordId;
	private Long userId;
	private Long projectId;
	private Date vipBeginDate;
	private Date vipEndDate;
	private Integer vipDay;
	private String updateDesc;
	private String userName;
	private int version;
	private Date createTime;
	private Date updateTime;

	public Long getVipRecordId() {
		return vipRecordId;
	}

	public void setVipRecordId(Long vipRecordId) {
		this.vipRecordId = vipRecordId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getVipBeginDate() {
		return vipBeginDate;
	}

	public void setVipBeginDate(Date vipBeginDate) {
		this.vipBeginDate = vipBeginDate;
	}

	public Date getVipEndDate() {
		return vipEndDate;
	}

	public void setVipEndDate(Date vipEndDate) {
		this.vipEndDate = vipEndDate;
	}

	public Integer getVipDay() {
		return vipDay;
	}

	public void setVipDay(Integer vipDay) {
		this.vipDay = vipDay;
	}

	public String getUpdateDesc() {
		return updateDesc;
	}

	public void setUpdateDesc(String updateDesc) {
		this.updateDesc = updateDesc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}