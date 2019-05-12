package com.car.vo;

import java.io.Serializable;

/**
 * 数据字典
 * 
 * @author wind
 */
public class SysDictVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long sysDictId;
	private String name;
	private String type;
	private String code;
	private String value;

	public Long getSysDictId() {
		return sysDictId;
	}

	public void setSysDictId(Long sysDictId) {
		this.sysDictId = sysDictId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
