
package com.car.form;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 支付表单
 *
 * @author wind
 */
@ApiModel(value = "支付表单")
public class PayForm {
	
	@ApiModelProperty(value = "用户ID")
	@NotBlank(message = "用户ID不能为空")
	private Long userId;
	
	@ApiModelProperty(value = "商品ID")
	@NotBlank(message = "商品ID不能为空")
	private Long commodityId;
	
	@ApiModelProperty(value = "人民币(保留小数点一位)")
	private String money;
	
	@ApiModelProperty(value = "支付类型(0支付宝/1微信)")
	private Integer payType;
	
	@ApiModelProperty(value = "订单号")
	@NotBlank(message = "订单号不能为空")
	private String orderNo;
	
//	@ApiModelProperty(value = "银行账号")
//	private String bank;
//	
//	@ApiModelProperty(value = "手机号")
//	private String cardNum;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

}
