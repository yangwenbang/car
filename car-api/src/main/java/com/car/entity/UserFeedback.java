package com.car.entity;


import java.io.Serializable;
import java.util.Date;

public class UserFeedback implements Serializable {

	private static final long serialVersionUID = -3776025894561378432L;

	private Long id;

	private Long userId;

	private String content;

	private Date createTime;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
