package com.car.vo;

import java.io.Serializable;

public class UserCoinVO implements Serializable {

	private static final long serialVersionUID = -4005752627554553235L;
	
	private Long userCoinId;
	private Long userId;
	private Double coin;
	private Integer version;

	public Long getUserCoinId() {
		return userCoinId;
	}

	public void setUserCoinId(Long userCoinId) {
		this.userCoinId = userCoinId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getCoin() {
		return coin;
	}

	public void setCoin(Double coin) {
		this.coin = coin;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}