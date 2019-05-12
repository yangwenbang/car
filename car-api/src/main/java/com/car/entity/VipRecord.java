package com.car.entity;

import java.io.Serializable;
import java.util.Date;

public class VipRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long userId;
	private Long projectId;
	private Date vipBeginDate;
	private Date vipEndDate;
	private Integer vipDay;
	private String userName;
	private String updateDesc;
	private Date createTime;
	private Date updateTime;
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUpdateDesc() {
		return updateDesc;
	}

	public void setUpdateDesc(String updateDesc) {
		this.updateDesc = updateDesc;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
