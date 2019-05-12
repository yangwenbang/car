package com.car.entity;

import java.io.Serializable;
import java.util.Date;

public class UserCoin implements Serializable {

	private static final long serialVersionUID = 6145296636132823094L;

	private Long id;
	private Long userId;
	private Double coin;
	private int version;
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

	public Double getCoin() {
		return coin;
	}

	public void setCoin(Double coin) {
		this.coin = coin;
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