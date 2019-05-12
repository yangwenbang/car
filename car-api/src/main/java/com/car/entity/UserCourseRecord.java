package com.car.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserCourseRecord implements Serializable {

	private static final long serialVersionUID = -4659502571312066303L;

	private Long id;
	private Long userId;
	private Integer cargoType;
	private Long cargoId;
	private Date buyDate;
	private BigDecimal actualMoney;
	private Date createTime;
	private Date updateTime;

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

	public Integer getCargoType() {
		return cargoType;
	}

	public void setCargoType(Integer cargoType) {
		this.cargoType = cargoType;
	}

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public BigDecimal getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(BigDecimal actualMoney) {
		this.actualMoney = actualMoney;
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