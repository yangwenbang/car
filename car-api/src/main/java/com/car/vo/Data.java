package com.car.vo;

public class Data {
	
	private int code;
	
	private String msg;

	private Object data;
	
	public Data() {
	}
	
	public Data(int code) {
		this.code = code;
	}
	
	public Data(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Data(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data ;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
