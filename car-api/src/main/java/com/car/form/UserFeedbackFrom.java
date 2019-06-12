package com.car.form;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "用户反馈表单")
public class UserFeedbackFrom implements Serializable {

	private static final long serialVersionUID = -3776025894561378431L;

	@ApiModelProperty(value = "反馈用户",required=true)
	@NotBlank(message = "反馈用户不能为空")
	private Long userId;

	@ApiModelProperty(value = "反馈内容")
	private String content;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content == null ? "" : content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
