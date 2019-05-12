package com.car.vo;

import java.io.Serializable;

public class SectionVO implements Serializable {

	private static final long serialVersionUID = -7498614793670070794L;
	
	private Long sectionId;
	private Long chapterId;
	private String sectionName;
	private Integer timeLength;
	private Integer sectionType;
	private String sectionUrl;
	private Integer free;
	private Integer readStatus = 0;
	private String handout;
	private Integer exerciseCount;

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public String getSectionName() {
		return sectionName == null ? "" : sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Integer getTimeLength() {
		return timeLength == null ? 0 : timeLength;
	}

	public void setTimeLength(Integer timeLength) {
		this.timeLength = timeLength;
	}

	public int getSectionType() {
		return sectionType;
	}

	public void setSectionType(int sectionType) {
		this.sectionType = sectionType;
	}

	public String getSectionUrl() {
		return sectionUrl == null ? "" : sectionUrl;
	}

	public void setSectionUrl(String sectionUrl) {
		this.sectionUrl = sectionUrl;
	}

	public Integer getFree() {
		return free == null ? 0 : free;
	}

	public void setFree(Integer free) {
		this.free = free;
	}

	public Integer getReadStatus() {
		return readStatus == null ? 0 : readStatus;
	}

	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}

	public String getHandout() {
		return handout == null ? "" : handout;
	}

	public void setHandout(String handout) {
		this.handout = handout;
	}

	public Integer getExerciseCount() {
		return exerciseCount == null ? 0 : exerciseCount;
	}

	public void setExerciseCount(Integer exerciseCount) {
		this.exerciseCount = exerciseCount;
	}

	public void setSectionType(Integer sectionType) {
		this.sectionType = sectionType;
	}
	
}