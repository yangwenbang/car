package com.car.form;

import java.util.List;

/**
 * @author wind
 */
public class UserExerciseAnswerForm {

	private Long userId;
	private Double score;
	private Integer spendTime;
	private List<ExerciseAnswerForm> exerciseAnswers;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<ExerciseAnswerForm> getExerciseAnswers() {
		return exerciseAnswers;
	}

	public void setExerciseAnswers(List<ExerciseAnswerForm> exerciseAnswers) {
		this.exerciseAnswers = exerciseAnswers;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}

}
