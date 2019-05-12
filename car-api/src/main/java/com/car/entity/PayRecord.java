package com.car.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayRecord implements Serializable {

	private static final long serialVersionUID = -6793267985437000524L;
	
	private Long id;
	private Long userId;
	private String userMobile;
	private String userName;
	private Date payDate;
	private BigDecimal coin;
	private Integer payType;
	private String bank;
	private String cardNum;
	private String payer;
	private Integer payOrReturn;
	private Integer cargoType;
	private Long cargoId;
	private String orderNo;
	private Integer payStatus;
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

	public String getUserMobile() {
		return userMobile == null ? "" : userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserName() {
		return userName == null ? "" : userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public BigDecimal getCoin() {
		return coin == null ? new BigDecimal(0) : coin;
	}

	public void setCoin(BigDecimal coin) {
		this.coin = coin;
	}

	public Integer getPayType() {
		return payType == null ? 0 : payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getBank() {
		return bank == null ? "" : bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCardNum() {
		return cardNum == null ? "" : cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPayer() {
		return payer == null ? "" : payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public Integer getPayOrReturn() {
		return payOrReturn == null ? 0 : payOrReturn;
	}

	public void setPayOrReturn(Integer payOrReturn) {
		this.payOrReturn = payOrReturn;
	}

	public Integer getCargoType() {
		return cargoType == null ? 0 : cargoType;
	}

	public void setCargoType(Integer cargoType) {
		this.cargoType = cargoType;
	}

	public Long getCargoId() {
		return cargoId == null ? 0 : cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public String getOrderNo() {
		return orderNo == null ? "" : orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getPayStatus() {
		return payStatus == null ? 0 : payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getVersion() {
		return version == null ? 0 : version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}