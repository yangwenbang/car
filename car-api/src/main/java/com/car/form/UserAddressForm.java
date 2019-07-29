package com.car.form;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wind
 */
@ApiModel(value = "用户地址表单")
public class UserAddressForm {

	@ApiModelProperty(value = "用户ID")
	@NotBlank(message = "用户ID不能为空")
	private Long userId;
	
	@ApiModelProperty(value = "用户地址ID(修改用)")
	private Long userAddressId;
	
	@ApiModelProperty(value = "收货人")
	private String receiver;
	
	@ApiModelProperty(value = "收货人手机号")
	private String mobile;
	
	@ApiModelProperty(value = "所在地址(省，市，区)")
	private String address;
	
	@ApiModelProperty(value = "详情地址")
	private String detailAddress;
	
	@ApiModelProperty(value = "是否默认地址(0不是/1是)")
	private Integer isDefault;
	
	@ApiModelProperty(value = "邮政编码")
	private String postcode;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Long getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(Long userAddressId) {
		this.userAddressId = userAddressId;
	}

}
