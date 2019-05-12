package com.car.vo;

import java.io.Serializable;

/**
 * @author wind
 */
public class UserErrorExerciseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userErrorExerciseId;
	private Long userId;
	private Long sectionId;
	private Long exerciseContentId;
	private Double errorRate;
	
	public Long getUserErrorExerciseId() {
		return userErrorExerciseId;
	}

	public void setUserErrorExerciseId(Long userErrorExerciseId) {
		this.userErrorExerciseId = userErrorExerciseId;
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
	
	public void setExerciseContentId(Long exerciseContentId) {
		this.exerciseContentId = exerciseContentId;
	}
	
	public Long getExerciseContentId() {
		return exerciseContentId;
	}

	public Double getErrorRate() {
		return errorRate;
	}

	public void setErrorRate(Double errorRate) {
		this.errorRate = errorRate;
	}
	
}
