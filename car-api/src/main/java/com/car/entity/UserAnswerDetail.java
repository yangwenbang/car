package com.car.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户答案明细
 * 
 * @author wind
 */
public class UserAnswerDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long userAnswerId;
	private Long userId;
	private Long exerciseContentId;
	private String exerciseAnswer;
	private Date createTime;
	private Date updateTime;

	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setUserAnswerId(Long userAnswerId) {
		this.userAnswerId = userAnswerId;
	}
	
	public Long getUserAnswerId() {
		return userAnswerId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setExerciseContentId(Long exerciseContentId) {
		this.exerciseContentId = exerciseContentId;
	}
	
	public Long getExerciseContentId() {
		return exerciseContentId;
	}
	
	public void setExerciseAnswer(String exerciseAnswer) {
		this.exerciseAnswer = exerciseAnswer;
	}
	
	public String getExerciseAnswer() {
		return exerciseAnswer;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
}
