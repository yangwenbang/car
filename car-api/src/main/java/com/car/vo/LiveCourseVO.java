package com.car.vo;

import java.io.Serializable;

/**
 * @author wind
 */
public class LiveCourseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long liveCourseId;
	private String courseName;
	private String introduce;
	private String introduceUrl;
	private String liveStartTime;
	private String liveEndTime;

	public Long getLiveCourseId() {
		return liveCourseId;
	}

	public void setLiveCourseId(Long liveCourseId) {
		this.liveCourseId = liveCourseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduceUrl(String introduceUrl) {
		this.introduceUrl = introduceUrl;
	}

	public String getIntroduceUrl() {
		return introduceUrl;
	}

	public void setLiveStartTime(String liveStartTime) {
		this.liveStartTime = liveStartTime;
	}

	public String getLiveStartTime() {
		return liveStartTime;
	}

	public void setLiveEndTime(String liveEndTime) {
		this.liveEndTime = liveEndTime;
	}

	public String getLiveEndTime() {
		return liveEndTime;
	}

}
