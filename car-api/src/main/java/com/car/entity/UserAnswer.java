package com.car.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wind
 */
public class UserAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long userId;
	private Long sectionId;
	private String sectionName;
	private Double score;
	private Integer spendTime;
	private Date createTime;
	private Date updateTime;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getScore() {
		return score;
	}

	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}

	public Integer getSpendTime() {
		return spendTime;
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
