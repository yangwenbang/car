package com.car.utils;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "返回类")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = -8484888486216844289L;
	private static final String SUCCESS = "success";
	private static final String ZERO = "0";

	@ApiModelProperty(value = "code: 状态: 0 - 成功, 其他 - 失败 , 600-token过期，需要重新登录")
	private String code = ZERO;
	
	@ApiModelProperty(value = "消息")
	private String msg = SUCCESS;
	
	@ApiModelProperty(value = "返回值对象")
	private T data;
	
	public Result() {
		super();
	}
	
	public Result(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public Result(String code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
	
	public Result(T data) {
		super();
		this.code = ZERO;
		this.msg = SUCCESS;
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
