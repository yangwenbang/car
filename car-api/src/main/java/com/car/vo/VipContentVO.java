package com.car.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class VipContentVO implements Serializable {

	private static final long serialVersionUID = 4946194801583989633L;

	private Long vipContentId;
	private String vipContent;
	private Integer vipDay;
	private BigDecimal vipMoney;

	public Long getVipContentId() {
		return vipContentId;
	}

	public void setVipContentId(Long vipContentId) {
		this.vipContentId = vipContentId;
	}

	public String getVipContent() {
		return vipContent;
	}

	public void setVipContent(String vipContent) {
		this.vipContent = vipContent;
	}

	public Integer getVipDay() {
		return vipDay;
	}

	public void setVipDay(Integer vipDay) {
		this.vipDay = vipDay;
	}

	public BigDecimal getVipMoney() {
		return vipMoney;
	}

	public void setVipMoney(BigDecimal vipMoney) {
		this.vipMoney = vipMoney;
	}

}