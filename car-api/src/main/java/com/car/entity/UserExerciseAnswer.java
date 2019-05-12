package com.car.entity;

import java.io.Serializable;
import java.util.Date;

public class UserExerciseAnswer implements Serializable {

	private static final long serialVersionUID = 1965001402708537249L;
	
	private Long id;
	private Long userId;
	private Long exerciseContentId;
	private String exerciseAnswer;
	private Date createTime;
	private Date updateTime;

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

	public Long getExerciseContentId() {
		return exerciseContentId;
	}

	public void setExerciseContentId(Long exerciseContentId) {
		this.exerciseContentId = exerciseContentId;
	}

	public String getExerciseAnswer() {
		return exerciseAnswer;
	}

	public void setExerciseAnswer(String exerciseAnswer) {
		this.exerciseAnswer = exerciseAnswer;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}