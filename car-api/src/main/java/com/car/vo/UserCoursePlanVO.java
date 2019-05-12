package com.car.vo;

import java.io.Serializable;

public class UserCoursePlanVO implements Serializable {

	private static final long serialVersionUID = 6882714245911537259L;
	
	private long userCoursePlanId;
	private long userId;
	private long sectionId;
	private String finishDate;

	public long getUserCoursePlanId() {
		return userCoursePlanId;
	}

	public void setUserCoursePlanId(long userCoursePlanId) {
		this.userCoursePlanId = userCoursePlanId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public String getFinishDate() {
		return finishDate == null ? "" : finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

}