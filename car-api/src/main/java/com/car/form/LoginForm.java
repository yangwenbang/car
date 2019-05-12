
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
public class LoginForm {
//    private String mobile;
//    private Integer equipmentType;
//    private String equipmentModel;
//    private String systemVersion;
//    private String softVersion;
//    private String verficationCode;

	@ApiModelProperty(value = "登录类型：0微信/1支付宝")
	private Integer loginType;

	@ApiModelProperty(value = "微信code")
	@NotBlank(message = "code不能为空")
	private String code;

	@ApiModelProperty(value = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginType() {
		return loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

}
