package com.car.vo;

import java.io.Serializable;

public class PayRecordVO implements Serializable {

	private static final long serialVersionUID = 6300663899824597141L;

	private Long payRecordId;
	private Long userId;
	private String userMobile;
	private String userName;
	private String payDate;
	private Integer payType;
	private String bank;
	private String cardNum;
	private String payer;
	private Integer payOrReturn;
	private Integer cargoType;
	private Long cargoId;
	private Integer payStatus;
	private Integer version;
	private Double coin;

	public Long getPayRecordId() {
		return payRecordId;
	}

	public void setPayRecordId(Long payRecordId) {
		this.payRecordId = payRecordId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public Integer getPayOrReturn() {
		return payOrReturn;
	}

	public void setPayOrReturn(Integer payOrReturn) {
		this.payOrReturn = payOrReturn;
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

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Double getCoin() {
		return coin;
	}

	public void setCoin(Double coin) {
		this.coin = coin;
	}

}