package com.car.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserCourseRecordVO implements Serializable {

	private static final long serialVersionUID = -4659502571312066303L;

	private Long userCourseRecordId;
	private Long userId;
	private Integer cargoType;
	private Long cargoId;
	private String buyDate;
	private BigDecimal actualMoney;

	public Long getUserCourseRecordId() {
		return userCourseRecordId;
	}

	public void setUserCourseRecordId(Long userCourseRecordId) {
		this.userCourseRecordId = userCourseRecordId;
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

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public BigDecimal getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(BigDecimal actualMoney) {
		this.actualMoney = actualMoney;
	}

}