package com.car.vo;

import java.io.Serializable;

public class ExerciseCountVO implements Serializable {

	private static final long serialVersionUID = 6328845444595193908L;

	private Long sectionId;
	private Long exerciseCount;

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Long getExerciseCount() {
		return exerciseCount;
	}

	public void setExerciseCount(Long exerciseCount) {
		this.exerciseCount = exerciseCount;
	}

}
