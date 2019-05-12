package com.car.vo;

import java.io.Serializable;

public class ExerciseTypeVO implements Serializable {

	private static final long serialVersionUID = 3116660179814412959L;

	private Long exerciseTypeId;
	private String exerciseName;
	private String description;
	private Integer exerciseType;

	public Long getExerciseTypeId() {
		return exerciseTypeId;
	}

	public void setExerciseTypeId(Long exerciseTypeId) {
		this.exerciseTypeId = exerciseTypeId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(Integer exerciseType) {
		this.exerciseType = exerciseType;
	}

}