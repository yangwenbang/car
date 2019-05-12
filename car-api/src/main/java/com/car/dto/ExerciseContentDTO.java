package com.car.dto;

import java.io.Serializable;
import java.util.List;

import com.car.vo.ExerContentVO;
import com.car.vo.ExerciseContentVO;

public class ExerciseContentDTO implements Serializable {

	private static final long serialVersionUID = 2387940313322844214L;

	private Long exerciseTypeId;
	private Integer exerciseType;
	private String exerciseName;
	private String description;
	private List<ExerciseContentVO> exerciseContents;
	
	public ExerciseContentDTO() {}

	public ExerciseContentDTO(Long exerciseTypeId, Integer exerciseType, String exerciseName, String description,
			List<ExerciseContentVO> exerciseContents) {
		super();
		this.exerciseTypeId = exerciseTypeId;
		this.exerciseType = exerciseType;
		this.exerciseName = exerciseName;
		this.description = description;
		this.exerciseContents = exerciseContents;
	}

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

	public List<ExerciseContentVO> getExerciseContents() {
		return exerciseContents;
	}

	public void setExerciseContents(List<ExerciseContentVO> exerciseContents) {
		this.exerciseContents = exerciseContents;
	}

}
