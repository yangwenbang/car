
package com.car.form;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登录表单
 * 
 * @author wind
 */
@ApiModel(value = "登录表单")
public class MobileLoginForm {
	
	@ApiModelProperty(value = "手机号", required = true)
	@NotBlank(message = "手机号不能为空")
	private String mobile;
	
	@ApiModelProperty(value = "用户设备类别(0安卓/1苹果)")
    private Integer equipmentType;
	
	@ApiModelProperty(value = "设备型号")
    private String equipmentModel;
	
	@ApiModelProperty(value = "系统版本号")
    private String systemVersion;

	@ApiModelProperty(value = "密码", required = true)
	@NotBlank(message = "密码不能为空")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getEquipmentType() {
		return equipmentType == null ? 0 : equipmentType;
	}

	public void setEquipmentType(Integer equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}
	
}
